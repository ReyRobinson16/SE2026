
package project.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadedUserComputeEngineAPIImpl
        implements UserComputeEngineAPI {

    private static final int THREAD_COUNT = 4;

    private final ComputationAPI computationAPI;
    private final DataStorageAPI dataStorageAPI;

    public MultiThreadedUserComputeEngineAPIImpl() {
        this(new ComputationAPIImpl(),
                new DataStorageAPIImpl());
    }

    public MultiThreadedUserComputeEngineAPIImpl(
            ComputationAPI computationAPI,
            DataStorageAPI dataStorageAPI) {

        if (computationAPI == null || dataStorageAPI == null) {
            throw new IllegalArgumentException(
                    "APIs cannot be null");
        }

        this.computationAPI = computationAPI;
        this.dataStorageAPI = dataStorageAPI;
    }

    @Override
    public String configureJob(JobConfig config) {
        try {
            JobManager manager =
                    new JobManager(computationAPI, dataStorageAPI);

            return manager.configureJob(config);

        } catch (RuntimeException e) {
            return getErrorMessage(e);
        }
    }

    @Override
    public String startJob(JobConfig config) {
        try {
            JobManager manager =
                    new JobManager(computationAPI, dataStorageAPI);

            manager.configureJob(config);

            StorageConfig storageConfig = new StorageConfig(
                    config.getInputSource(),
                    config.getOutputDestination());

            runParallelJob(manager, storageConfig);

            return "Job completed";

        } catch (RuntimeException e) {
            return getErrorMessage(e);
        }
    }

    private void runParallelJob(
            JobManager manager,
            StorageConfig config) {

        InputData inputData = manager.readJobInput(config);
        List<Integer> numbers = inputData.getNumbers();

        ExecutorService executor =
                Executors.newFixedThreadPool(THREAD_COUNT);

        try {
            List<Future<ComputeResult>> results =
                    new ArrayList<>();

            for (Integer number : numbers) {
                results.add(executor.submit(
                        () -> computationAPI.compute(
                                new ComputeRequest(number))));
            }

            writeResults(manager, config, results);

        } finally {
            executor.shutdownNow();
        }
    }

    private void writeResults(
            JobManager manager,
            StorageConfig config,
            List<Future<ComputeResult>> results) {

        for (Future<ComputeResult> future : results) {
            ComputeResult result = getResult(future);
            manager.writeJobResult(config, result);
        }
    }

    private ComputeResult getResult(Future<ComputeResult> future) {
        try {
            return future.get();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException(
                    "Computation interrupted", e);

        } catch (ExecutionException e) {
            throw new IllegalStateException(
                    "Computation failed", e.getCause());
        }
    }

    private String getErrorMessage(RuntimeException e) {
        String message = e.getMessage();

        if (message == null || message.isEmpty()) {
            message = e.getClass().getSimpleName();
        }

        return "ERROR: " + message;
    }
}
