package project.api;

import project.annotations.NetworkAPI;

@NetworkAPI
public interface UserComputeEngineAPI {
    String configureJob(JobConfig config);
}