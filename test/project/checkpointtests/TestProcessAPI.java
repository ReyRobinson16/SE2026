package project.checkpointtests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import project.api.*;

public class TestProcessAPI {

    @Test
    public void testStorage() {
        DataStorageAPIImpl api = new DataStorageAPIImpl();

        StorageConfig config = new StorageConfig("input", "output");
        ComputeResult result = new ComputeResult("Prime result");

        api.readInputData(config);
        api.writeData(config, result);

        Assertions.assertEquals(
            "Prime result",
            api.getLastResult().getOutput()
        );
    }
}