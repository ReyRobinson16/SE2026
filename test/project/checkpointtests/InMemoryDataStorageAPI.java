package project.checkpointtests;

import project.api.ComputeResult;
import project.api.DataStorageAPI;
import project.api.StorageConfig;

public class InMemoryDataStorageAPI implements DataStorageAPI {
    private final InMemoryInputConfig inputConfig;
    private final InMemoryOutputConfig outputConfig;

    public InMemoryDataStorageAPI(InMemoryInputConfig inputConfig, InMemoryOutputConfig outputConfig) {
        this.inputConfig = inputConfig;
        this.outputConfig = outputConfig;
    }

    public InMemoryInputConfig getInputConfig() {
        return inputConfig;
    }

    public InMemoryOutputConfig getOutputConfig() {
        return outputConfig;
    }

    @Override
    public void readInputData(StorageConfig config) {
    }

    @Override
    public void writeData(StorageConfig config, ComputeResult result) {
    }
}