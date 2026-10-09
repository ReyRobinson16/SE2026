package project.checkpointtests;

import project.api.*;

public class InMemoryDataStorageAPI implements DataStorageAPI {

    private final InMemoryInputConfig inputConfig;
    private final InMemoryOutputConfig outputConfig;

    public InMemoryDataStorageAPI(
            InMemoryInputConfig inputConfig,
            InMemoryOutputConfig outputConfig) {

        this.inputConfig = inputConfig;
        this.outputConfig = outputConfig;
    }

    @Override
    public void readInputData(StorageConfig config) {
    }

    @Override
    public void writeData(StorageConfig config, ComputeResult result) {
        outputConfig.addResult(result);
    }

    public InMemoryInputConfig getInputConfig() {
        return inputConfig;
    }

    public InMemoryOutputConfig getOutputConfig() {
        return outputConfig;
    }
}