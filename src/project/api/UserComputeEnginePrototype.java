package project.api;

import project.annotations.NetworkAPIPrototype;

@NetworkAPIPrototype
public class UserComputeEnginePrototype {
    public String runPrototype(UserComputeEngineAPI api) {
        JobConfig jobConfig = new JobConfig("input.csv", "output.csv", ';');
        return api.configureJob(jobConfig);
    }
}