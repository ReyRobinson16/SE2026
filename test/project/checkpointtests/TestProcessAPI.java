package project.checkpointtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import project.api.ComputeResult;
import project.api.DataStorageAPI;
import project.api.DataStorageAPIImpl;
import project.api.StorageConfig;

public class TestProcessAPI {
    @Test
    public void testProcessAPISmoke() {
        DataStorageAPI api = new DataStorageAPIImpl();
        StorageConfig config = new StorageConfig("input.txt");
        ComputeResult result = new ComputeResult("Data");

        Assertions.assertDoesNotThrow(() -> {
            api.readInputData(config);
            api.writeData(config, result);
        });
    }
}