package project.checkpointtests;

import project.api.JobConfig;
import project.api.UserComputeEngineAPI;

public class TestUserComputeEngineAPI implements UserComputeEngineAPI {
    @Override
    public String configureJob(JobConfig config) {
        return "TestConfig:" + config.getInputSource() + "->" + config.getOutputDestination();
    }
}