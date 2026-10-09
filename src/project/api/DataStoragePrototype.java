package project.api;

import project.annotations.ProcessAPIPrototype;

@ProcessAPIPrototype
public class DataStoragePrototype {

    @ProcessAPIPrototype
    public void prototypeMethod(DataStorageAPI api) {
        StorageConfig config = null;
        ComputeResult result = null;

        api.readInputData(config);
        api.writeData(config, result);
    }
}