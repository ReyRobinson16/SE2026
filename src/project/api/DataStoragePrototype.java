
package project.api;

import project.annotations.ProcessAPIPrototype;

@ProcessAPIPrototype
public class DataStoragePrototype {

    @ProcessAPIPrototype
    public void prototypeMethod(DataStorageAPI api) {
        StorageConfig config = new StorageConfig("input.txt", "output.txt");
        ComputeResult result = new ComputeResult("10: largest_prime=7 total_primes=4");

        api.readInputData(config);
        api.writeData(config, result);
    }
}
