
package project.api;

public class UserComputeEngineAPIImpl
        implements UserComputeEngineAPI {

    private final ComputationAPI computationAPI;
    private final DataStorageAPI dataStorageAPI;

    public UserComputeEngineAPIImpl() {
        this(new ComputationAPIImpl(),
             new DataStorageAPIImpl());
    }

    public UserComputeEngineAPIImpl(
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

            if (config == null) {
                throw new IllegalArgumentException(
                        "Job config cannot be null");
            }

            StorageConfig storageConfig = new StorageConfig(
                    config.getInputSource(),
                    config.getOutputDestination()
            );

            manager.runFileJob(storageConfig);

            return "Job completed";

        } catch (RuntimeException e) {
            return getErrorMessage(e);
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
