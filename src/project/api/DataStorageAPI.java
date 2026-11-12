
package project.api;

import project.annotations.ProcessAPI;

@ProcessAPI
public interface DataStorageAPI {

    InputData readInputData(StorageConfig config);

    String writeData(StorageConfig config, ComputeResult result);

    String clearOutput(StorageConfig config);
}
