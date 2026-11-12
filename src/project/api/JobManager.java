
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
                || config.getInputSource().isBlank()
                || config.getOutputDestination() == null
                || config.getOutputDestination().isBlank()) {
            throw new IllegalArgumentException("Invalid job config");
        }

        return config.getInputSource()
                + " -> "
                + config.getOutputDestination();
    }

    public ComputeResult runJob(int number, StorageConfig config) {

        validateStorageConfig(config);

        // Any integer is allowed as a computation input.
        ComputeResult result =
                computationAPI.compute(new ComputeRequest(number));

        if (result == null) {
            throw new IllegalStateException(
                    "Computation returned no result");
        }

        dataStorageAPI.writeData(config, result);

        return result;
    }

    public void runFileJob(StorageConfig config) {

        validateStorageConfig(config);

        InputData inputData = dataStorageAPI.readInputData(config);

        if (inputData == null || inputData.getNumbers() == null) {
            throw new IllegalArgumentException(
                    "Input data cannot be null");
        }

        for (Integer number : inputData.getNumbers()) {
            if (number == null) {
                throw new IllegalArgumentException(
                        "Input data cannot contain null numbers");
            }
        }

        dataStorageAPI.clearOutput(config);

        for (Integer number : inputData.getNumbers()) {

            ComputeResult result =
                    computationAPI.compute(new ComputeRequest(number));

            if (result == null) {
                throw new IllegalStateException(
                        "Computation returned no result");
            }

            dataStorageAPI.writeData(config, result);
        }
    }

    private void validateStorageConfig(StorageConfig config) {

        if (config == null
                || config.getInputSource() == null
                || config.getInputSource().isBlank()
                || config.getOutputDestination() == null
                || config.getOutputDestination().isBlank()) {
            throw new IllegalArgumentException(
                    "Invalid storage configuration");
        }
    }
}
