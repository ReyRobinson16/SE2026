
package project.api;

import project.annotations.ProcessAPI;

@ProcessAPI
public interface DataStorageAPI {

    InputData readInputData(StorageConfig config);

    void writeData(StorageConfig config, ComputeResult result);
}
