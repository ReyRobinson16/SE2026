
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

        if (config == null) {
            throw new IllegalArgumentException(
                    "Job config cannot be null");
        }

        JobManager manager =
                new JobManager(computationAPI, dataStorageAPI);

        return manager.configureJob(config);
    }

    @Override
    public String startJob(JobConfig config) {

        if (config == null) {
            throw new IllegalArgumentException(
                    "Job config cannot be null");
        }

        JobManager manager =
                new JobManager(computationAPI, dataStorageAPI);

        StorageConfig storageConfig = new StorageConfig(
                config.getInputSource(),
                config.getOutputDestination()
        );

        manager.runFileJob(storageConfig);

        return "Job completed";
    }
}
