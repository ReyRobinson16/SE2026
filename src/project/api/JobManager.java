
package project.api;

public class JobManager {

    private final ComputationAPI computationAPI;
    private final DataStorageAPI dataStorageAPI;

    public JobManager(
            ComputationAPI computationAPI,
            DataStorageAPI dataStorageAPI) {

        if (computationAPI == null || dataStorageAPI == null) {
            throw new IllegalArgumentException("APIs cannot be null");
        }

        this.computationAPI = computationAPI;
        this.dataStorageAPI = dataStorageAPI;
    }

    public String configureJob(JobConfig config) {

        if (config == null
                || config.getInputSource() == null
                || config.getOutputDestination() == null) {
            throw new IllegalArgumentException("Invalid job config");
        }

        return config.getInputSource()
                + " -> "
                + config.getOutputDestination();
    }

    public ComputeResult runJob(int number, StorageConfig config) {

        if (config == null) {
            throw new IllegalArgumentException("Config cannot be null");
        }

        ComputeResult result =
                computationAPI.compute(new ComputeRequest(number));

        dataStorageAPI.writeData(config, result);

        return result;
    }

    public void runFileJob(StorageConfig config) {

        if (config == null) {
            throw new IllegalArgumentException("Config cannot be null");
        }

        InputData inputData = dataStorageAPI.readInputData(config);

        if (inputData == null || inputData.getNumbers() == null) {
            throw new IllegalArgumentException("Input data cannot be null");
        }

        dataStorageAPI.clearOutput(config);

        for (int number : inputData.getNumbers()) {
            ComputeResult result =
                    computationAPI.compute(new ComputeRequest(number));

            dataStorageAPI.writeData(config, result);
        }
    }
}
