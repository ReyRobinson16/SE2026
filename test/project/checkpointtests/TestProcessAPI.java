
package project.checkpointtests;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import project.api.DataStorageAPIImpl;
import project.api.StorageConfig;
import project.api.ComputeResult;

public class TestProcessAPI {

    @Test
    public void testStorage() {

        DataStorageAPIImpl api = new DataStorageAPIImpl();

        StorageConfig config = mock(StorageConfig.class);
        ComputeResult result = mock(ComputeResult.class);

        api.readInputData(config);
        api.writeData(config, result);

        Assertions.assertNotNull(api);
    }
}
