package project.api;

public class UserComputeEngineAPIImpl implements UserComputeEngineAPI {
    private final ComputationAPI computationAPI;
    private final DataStorageAPI dataStorageAPI;

    public UserComputeEngineAPIImpl() {
        this.computationAPI = new ComputationAPIImpl();
        this.dataStorageAPI = new DataStorageAPIImpl();
    }

    public UserComputeEngineAPIImpl(ComputationAPI computationAPI, DataStorageAPI dataStorageAPI) {
        this.computationAPI = computationAPI;
        this.dataStorageAPI = dataStorageAPI;
    }

    public ComputationAPI getComputationAPI() {
        return computationAPI;
    }

    public DataStorageAPI getDataStorageAPI() {
        return dataStorageAPI;
    }

    @Override
    public String configureJob(JobConfig config) {
        JobManager manager = new JobManager(computationAPI, dataStorageAPI);
        manager.executeJob(config);
        return "Job Configured: " + config.getInputSource();
    }
}