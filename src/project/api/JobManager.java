
package project.api;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class JobManager {

    private final ComputationAPI computationAPI;
    private final DataStorageAPI dataStorageAPI;

    public JobManager(ComputationAPI computationAPI,
                      DataStorageAPI dataStorageAPI) {
        this.computationAPI = computationAPI;
        this.dataStorageAPI = dataStorageAPI;
    }

    public String configureJob(JobConfig config) {
        return config.getInputSource()
                + " -> "
                + config.getOutputDestination();
    }

    public ComputeResult runJob(int number, StorageConfig config) {
        dataStorageAPI.readInputData(config);

        ComputeRequest request = new ComputeRequest(number);
        ComputeResult result = computationAPI.compute(request);

        dataStorageAPI.writeData(config, result);

        return result;
    }

    public void runFileJob(StorageConfig config) {

        InputData inputData = dataStorageAPI.readInputData(config);

        try {
            Files.deleteIfExists(Path.of(config.getOutputDestination()));
        } catch (IOException e) {
            throw new IllegalStateException("Unable to reset output file", e);
        }

        for (int number : inputData.getNumbers()) {
            ComputeRequest request = new ComputeRequest(number);
            ComputeResult result = computationAPI.compute(request);
            dataStorageAPI.writeData(config, result);
        }
    }
}
