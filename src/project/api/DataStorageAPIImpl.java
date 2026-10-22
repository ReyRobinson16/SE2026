
package project.api;

public class DataStorageAPIImpl implements DataStorageAPI {

    private ComputeResult lastResult;

    @Override
    public void readInputData(StorageConfig config) {
        // Empty implementation for Checkpoint 3
    }

    @Override
    public void writeData(StorageConfig config,
                          ComputeResult result) {
        // Empty implementation for Checkpoint 3
    }

    public ComputeResult getLastResult() {
        return lastResult;
    }
}
