
package project.checkpointtests;

import java.util.ArrayList;

import project.api.DataStorageAPI;
import project.api.StorageConfig;
import project.api.ComputeResult;
import project.api.InputData;

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
    public InputData readInputData(StorageConfig config) {
        return new InputData(new ArrayList<>(inputConfig.getInputs()));
    }

    @Override
    public String writeData(StorageConfig config, ComputeResult result) {

        if (result == null || result.getOutput() == null) {
            return "ERROR: Invalid compute result";
        }

        outputConfig.addResult(result);
        return "SUCCESS";
    }

    @Override
    public String clearOutput(StorageConfig config) {
        outputConfig.getResults().clear();
        return "SUCCESS";
    }

    public InMemoryInputConfig getInputConfig() {
        return inputConfig;
    }

    public InMemoryOutputConfig getOutputConfig() {
        return outputConfig;
    }
}
