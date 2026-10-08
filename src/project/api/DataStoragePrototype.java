package project.api;

import project.annotations.ProcessAPIPrototype;

@ProcessAPIPrototype
public class DataStoragePrototype {
    public void prototypeDataStorage(DataStorageAPI api) {
        api.readInputData("Demo");
        api.writeData("Demo", "100:largest prime=97,total prime=25");
    }
}