package project.api;

public class ComputationAPIImpl implements ComputationAPI {
    private final DataStorageAPI dataStorageAPI;

    public ComputationAPIImpl() {
        this.dataStorageAPI = null;
    }

    public ComputationAPIImpl(DataStorageAPI dataStorageAPI) {
        this.dataStorageAPI = dataStorageAPI;
    }

    @Override
    public String computeResult(int input) {
        return "";
    }
}