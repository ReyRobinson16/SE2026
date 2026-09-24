package project.api;

import project.annotations.NetworkAPIPrototype;

public class UserComputeEnginePrototype {
    @NetworkAPIPrototype
    public void prototypeUserComputeEngine(UserComputeEngineAPI api) {
        api.configureJob("Demo", "Demo", ';');
        api.configureJob("Demo", "Demo");
    }
}