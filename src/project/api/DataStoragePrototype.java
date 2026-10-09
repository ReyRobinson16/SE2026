package project.api;

import project.annotations.ProcessAPIPrototype;

@ProcessAPIPrototype
public class DataStoragePrototype {
    public void runPrototype(DataStorageAPI api) {
        StorageConfig config = new StorageConfig("input.txt");
        ComputeResult result = new ComputeResult("Sample Output");
        api.readInputData(config);
        api.writeData(config, result);
    }
}