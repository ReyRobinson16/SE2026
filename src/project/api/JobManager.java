
package project.api;

public class JobManager {

    private final ComputationAPI computationAPI;
    private final DataStorageAPI dataStorageAPI;

<<<<<<< Updated upstream
    public JobManager(ComputationAPI computationAPI,
                      DataStorageAPI dataStorageAPI) {
=======
    public JobManager(
            ComputationAPI computationAPI,
            DataStorageAPI dataStorageAPI) {

>>>>>>> Stashed changes
        this.computationAPI = computationAPI;
        this.dataStorageAPI = dataStorageAPI;
    }

<<<<<<< Updated upstream
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
=======
    public ComputeResult executeJob(JobConfig jobConfig) {

        StorageConfig storageConfig =
                new StorageConfig(jobConfig.getInputSource());

        dataStorageAPI.readInputData(storageConfig);

        ComputeRequest request =
                new ComputeRequest(100);

        ComputeResult result =
                computationAPI.compute(request);

        dataStorageAPI.writeData(storageConfig, result);
>>>>>>> Stashed changes

        return result;
    }
}
