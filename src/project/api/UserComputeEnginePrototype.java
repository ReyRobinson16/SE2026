package project.api;

import project.annotations.NetworkAPIPrototype;

@NetworkAPIPrototype
public class UserComputeEnginePrototype {
    public void prototypeUserComputeEngine(UserComputeEngineAPI api) {
        api.configureJob("Demo", "Demo", ';');
        api.configureJob("Demo", "Demo");
    }
}