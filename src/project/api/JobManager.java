package project.api;

public class JobManager {

    private final ComputationAPI computationAPI;
    private final DataStorageAPI dataStorageAPI;

    public JobManager(ComputationAPI computationAPI,
                      DataStorageAPI dataStorageAPI) {
        this.computationAPI = computationAPI;
        this.dataStorageAPI = dataStorageAPI;
    }

    public String configureJob(JobConfig config) {
        if (config == null) {
            throw new IllegalArgumentException(
                "Job config cannot be null"
            );
        }

        return config.getInputSource()
                + " -> "
                + config.getOutputDestination();
    }

    public ComputeResult runJob(int number,
                                StorageConfig config) {
        dataStorageAPI.readInputData(config);

        ComputeRequest request = new ComputeRequest(number);
        ComputeResult result = computationAPI.compute(request);

        dataStorageAPI.writeData(config, result);

        return result;
    }
}