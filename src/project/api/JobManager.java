
package project.api;

public class JobManager {

    private final ComputationAPI computationAPI;
    private final DataStorageAPI dataStorageAPI;

    public JobManager(ComputationAPI computationAPI,
                      DataStorageAPI dataStorageAPI) {

        if (computationAPI == null || dataStorageAPI == null) {
            throw new IllegalArgumentException(
                    "APIs cannot be null");
        }

        this.computationAPI = computationAPI;
        this.dataStorageAPI = dataStorageAPI;
    }

    public String configureJob(JobConfig config) {

        if (config == null) {
            throw new IllegalArgumentException(
                    "Job config cannot be null");
        }

        if (config.getInputSource() == null
                || config.getInputSource().isBlank()
                || config.getOutputDestination() == null
                || config.getOutputDestination().isBlank()) {

            throw new IllegalArgumentException(
                    "Input and output paths are required");
        }

        return config.getInputSource()
                + " -> "
                + config.getOutputDestination();
    }

    public ComputeResult runJob(int number, StorageConfig config) {

        if (config == null) {
            throw new IllegalArgumentException(
                    "Storage config cannot be null");
        }

        dataStorageAPI.readInputData(config);

        ComputeRequest request = new ComputeRequest(number);
        ComputeResult result = computationAPI.compute(request);

        dataStorageAPI.writeData(config, result);

        return result;
    }

    public void runFileJob(StorageConfig config) {

        if (config == null) {
            throw new IllegalArgumentException(
                    "Storage config cannot be null");
        }

        InputData inputData = dataStorageAPI.readInputData(config);

        if (inputData == null || inputData.getNumbers() == null) {
            throw new IllegalArgumentException(
                    "Input data cannot be null");
        }

        for (int number : inputData.getNumbers()) {
            ComputeRequest request = new ComputeRequest(number);
            ComputeResult result = computationAPI.compute(request);
            dataStorageAPI.writeData(config, result);
        }
    }
}
