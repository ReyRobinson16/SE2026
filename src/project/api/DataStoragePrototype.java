package project.api;

import project.annotations.ProcessAPIPrototype;

@ProcessAPIPrototype
public class DataStoragePrototype {

    @ProcessAPIPrototype
    public void prototypeMethod(DataStorageAPI api, StorageConfig config, ComputeResult result) {
        api.readInputData(config);
        api.writeData(config, result);
    }
}