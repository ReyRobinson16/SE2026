package project.api;

import project.annotations.NetworkAPIPrototype;

@NetworkAPIPrototype
public class UserComputeEnginePrototype {

    @NetworkAPIPrototype
    public String runPrototype(UserComputeEngineAPI api, JobConfig config) {
        return api.configureJob(config);
    }
}