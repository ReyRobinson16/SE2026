package project.api;

import project.annotations.ProcessAPIPrototype;

public class DataStoragePrototype {

    @ProcessAPIPrototype
    public WriteResult prototypeDataStorage(DataStorageAPI api) {
        DataSet inputData = api.readData("db://inputs");
        return api.writeData("db://outputs", "100:largest_prime=97,total_primes=25");
    }
}