
package project.api;

public class JobManager {

    private final ComputationAPI computationAPI;
    private final DataStorageAPI dataStorageAPI;

    public JobManager(
            ComputationAPI computationAPI,
            DataStorageAPI dataStorageAPI) {

        if (computationAPI == null || dataStorageAPI == null) {
            throw new IllegalArgumentException(
                    "APIs cannot be null");
        }

        this.computationAPI = computationAPI;
        this.dataStorageAPI = dataStorageAPI;
    }

    public String configureJob(JobConfig config) {

        validateStorageConfig(config);

        return "Job configured";
    }

    public void runJob(ComputeRequest request) {

        if (request == null) {
            throw new IllegalArgumentException(
                    "Compute request cannot be null");
        }

        ComputeResult result = computationAPI.compute(request);

        if (result == null) {
            throw new IllegalStateException(
                    "Computation returned no result");
        }
    }

    public void runFileJob(StorageConfig config) {

        validateStorageConfig(config);

        String clearStatus =
                dataStorageAPI.clearOutput(config);

        checkStorageStatus(clearStatus);

        InputData inputData =
                dataStorageAPI.readInputData(config);

        if (inputData == null || inputData.getNumbers() == null) {
            throw new IllegalStateException(
                    "Input data is invalid");
        }

        for (Integer number : inputData.getNumbers()) {
            if (number == null) {
                throw new IllegalArgumentException(
                        "Input data cannot contain null numbers");
            }
        }

        for (Integer number : inputData.getNumbers()) {

            ComputeRequest request =
                    new ComputeRequest(number);

            ComputeResult result =
                    computationAPI.compute(request);

            if (result == null) {
                throw new IllegalStateException(
                        "Computation returned no result");
            }

            String writeStatus =
                    dataStorageAPI.writeData(config, result);

            checkStorageStatus(writeStatus);
        }
    }

    private void checkStorageStatus(String status) {

        if (!"SUCCESS".equals(status)) {
            throw new IllegalStateException(
                    status == null
                            ? "Storage operation failed"
                            : status);
        }
    }

    private void validateStorageConfig(JobConfig config) {

        if (config == null
                || config.getInputSource() == null
                || config.getInputSource().isBlank()
                || config.getOutputDestination() == null
                || config.getOutputDestination().isBlank()) {

            throw new IllegalArgumentException(
                    "Invalid storage configuration");
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
