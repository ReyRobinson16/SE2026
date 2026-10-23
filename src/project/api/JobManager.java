
package project.api;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;

public class JobManager {

    private final ComputationAPI computationAPI;
    private final DataStorageAPI dataStorageAPI;

    public JobManager(ComputationAPI computationAPI,
                      DataStorageAPI dataStorageAPI) {
        this.computationAPI = computationAPI;
        this.dataStorageAPI = dataStorageAPI;
    }

    public String configureJob(JobConfig config) {
        if (config == null) {
            throw new IllegalArgumentException(
                "Job config cannot be null"
            );
        }

        return config.getInputSource()
                + " -> "
                + config.getOutputDestination();
    }

    public ComputeResult runJob(int number,
                                StorageConfig config) {
        dataStorageAPI.readInputData(config);

        ComputeRequest request = new ComputeRequest(number);
        ComputeResult result = computationAPI.compute(request);

        dataStorageAPI.writeData(config, result);

        return result;
    }

    public void runFileJob(StorageConfig config) {
        if (config == null) {
    throw new IllegalArgumentException(
        "Storage config cannot be null"
    );
}
        dataStorageAPI.readInputData(config);

        if (!(dataStorageAPI instanceof DataStorageAPIImpl)) {
            throw new IllegalStateException(
                "File job requires DataStorageAPIImpl"
            );
        }

        DataStorageAPIImpl storage =
                (DataStorageAPIImpl) dataStorageAPI;

        List<Integer> numbers = storage.getInputNumbers();

        try {
            Files.deleteIfExists(
                Path.of(config.getOutputDestination())
            );
        } catch (IOException e) {
            throw new IllegalStateException(
                "Unable to reset output file", e
            );
        }

        for (int number : numbers) {
            ComputeRequest request = new ComputeRequest(number);
            ComputeResult result = computationAPI.compute(request);
            dataStorageAPI.writeData(config, result);
        }
    }
}
