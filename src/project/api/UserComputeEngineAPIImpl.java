package project.api;

public class UserComputeEngineAPIImpl implements UserComputeEngineAPI {
    private final ComputationAPI computationAPI;
    private final DataStorageAPI dataStorageAPI;

    public UserComputeEngineAPIImpl() {
        this.computationAPI = null;
        this.dataStorageAPI = null;
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
    @SuppressWarnings("unused")
    public String configureJob(String inputSource, String outputDestination, char delimiter) {
        return "";
    }

    @Override
    @SuppressWarnings("unused")
    public String configureJob(String inputSource, String outputDestination) {
        return "";
    }
}