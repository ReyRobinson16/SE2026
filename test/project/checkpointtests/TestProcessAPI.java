
package project.checkpointtests;

<<<<<<< Updated upstream
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
=======
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

>>>>>>> Stashed changes
import project.api.DataStorageAPIImpl;
import project.api.StorageConfig;
import project.api.ComputeResult;

public class TestProcessAPI {

    @Test
<<<<<<< Updated upstream
    public void testStorage() {
        DataStorageAPIImpl api = new DataStorageAPIImpl();

        StorageConfig config =
                new StorageConfig("input", "output");

        ComputeResult result =
                new ComputeResult("Prime result");

        api.readInputData(config);
        api.writeData(config, result);

        Assertions.assertEquals(
                "Prime result",
                api.getLastResult().getOutput()
        );
=======
    public void testStorageStub() {

        // Create mock objects
        StorageConfig mockConfig =
                mock(StorageConfig.class);

        ComputeResult mockResult =
                mock(ComputeResult.class);

        // Explicitly create the implementation
        DataStorageAPIImpl api =
                new DataStorageAPIImpl();

        Assertions.assertNotNull(api);

        // Test empty API methods
        api.readInputData(mockConfig);
        api.writeData(mockConfig, mockResult);

        // Empty implementation should not store results
        Assertions.assertNull(api.getLastResult());
>>>>>>> Stashed changes
    }
}
