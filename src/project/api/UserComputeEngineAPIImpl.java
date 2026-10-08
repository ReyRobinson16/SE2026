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

    @Override
    public String configureJob(String inputSource, String outputDestination, char delimiter) {
        return "";
    }

    @Override
    public String configureJob(String inputSource, String outputDestination) {
        return "";
    }
}