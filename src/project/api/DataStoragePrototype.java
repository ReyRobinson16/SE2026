package project.api;

import project.annotations.ProcessAPIPrototype;

public class DataStoragePrototype {
    @ProcessAPIPrototype
    public void prototypeDataStorage(DataStorageAPI api) {
        api.readInputData("Demo");
        api.writeData("Demo", "100:largest prime=97,total primes=25");
    }
}