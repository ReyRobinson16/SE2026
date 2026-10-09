package project.api;

public class DataStorageAPIImpl implements DataStorageAPI {

    private ComputeResult lastResult;

    @Override
    public void readInputData(StorageConfig config) {
        if (config == null) {
            throw new IllegalArgumentException(
                "Storage config cannot be null"
            );
        }
    }

    @Override
    public void writeData(StorageConfig config,
                          ComputeResult result) {
        if (config == null || result == null) {
            throw new IllegalArgumentException(
                "Config and result are required"
            );
        }

        lastResult = result;
    }

    public ComputeResult getLastResult() {
        return lastResult;
    }
}