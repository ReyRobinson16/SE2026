
package project.checkpointtests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.mockito.Mockito.mock;

import project.api.DataStorageAPIImpl;
import project.api.StorageConfig;
import project.api.ComputeResult;

public class TestProcessAPI {

    @Test
    public void testStorageAPI() {

        // Mock the storage configuration
        StorageConfig mockConfig =
                mock(StorageConfig.class);

        // Mock the computation result
        ComputeResult mockResult =
                mock(ComputeResult.class);

        // Explicitly create the real implementation
        DataStorageAPIImpl api =
                new DataStorageAPIImpl();

        // Verify the implementation was created
        Assertions.assertNotNull(api);

        // Call the storage API methods
        api.readInputData(mockConfig);
        api.writeData(mockConfig, mockResult);
    }
}
