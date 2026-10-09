package project.api;

public class JobManager {
    private final ComputationAPI computationAPI;
    private final DataStorageAPI dataStorageAPI;

    public JobManager(ComputationAPI computationAPI, DataStorageAPI dataStorageAPI) {
        this.computationAPI = computationAPI;
        this.dataStorageAPI = dataStorageAPI;
    }

    public ComputeResult executeJob(JobConfig jobConfig) {
        StorageConfig storageConfig = new StorageConfig(jobConfig.getInputSource());
        dataStorageAPI.readInputData(storageConfig);

        ComputeRequest request = new ComputeRequest(100);
        ComputeResult result = computationAPI.compute(request);

        dataStorageAPI.writeData(storageConfig, result);
        return result;
    }
}