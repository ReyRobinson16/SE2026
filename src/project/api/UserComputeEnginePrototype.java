package project.api;

import project.annotations.NetworkAPIPrototype;

@NetworkAPIPrototype
public class UserComputeEnginePrototype {

    @NetworkAPIPrototype
    public String prototypeMethod(UserComputeEngineAPI api) {
        JobConfig config = null;
        return api.configureJob(config);
    }
}