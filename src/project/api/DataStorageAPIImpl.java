
package project.api;

public class DataStorageAPIImpl implements DataStorageAPI {

    private ComputeResult lastResult;

    @Override
    public void readInputData(StorageConfig config) {
<<<<<<< Updated upstream
        if (config == null) {
            throw new IllegalArgumentException(
                "Storage config cannot be null"
            );
        }
=======
        // Empty implementation
>>>>>>> Stashed changes
    }

    @Override
    public void writeData(StorageConfig config,
                          ComputeResult result) {
<<<<<<< Updated upstream
        if (config == null || result == null) {
            throw new IllegalArgumentException(
                "Config and result are required"
            );
        }

        lastResult = result;
    }

    public ComputeResult getLastResult() {
        return lastResult;
=======
        // Empty implementation
>>>>>>> Stashed changes
    }

    public ComputeResult getLastResult() {
        return lastResult;
    }
}
