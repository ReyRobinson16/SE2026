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

        this.computationAPI = computationAPI;
        this.dataStorageAPI = dataStorageAPI;
    }

    @Override
    public String configureJob(JobConfig config) {
        JobManager manager =
                new JobManager(computationAPI, dataStorageAPI);

        return manager.configureJob(config);
    }
}