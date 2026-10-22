
package project.checkpointtests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.mockito.Mockito.mock;

import project.api.ComputationAPI;
import project.api.DataStorageAPI;
import project.api.UserComputeEngineAPIImpl;

public class TestNetworkAPI {

    @Test
    public void testNetworkAPI() {

        // Mock both API dependencies
        ComputationAPI mockComputation =
                mock(ComputationAPI.class);

        DataStorageAPI mockStorage =
                mock(DataStorageAPI.class);

        // Explicit constructor call required by Checkpoint 3
        UserComputeEngineAPIImpl api =
                new UserComputeEngineAPIImpl(
                        mockComputation,
                        mockStorage
                );

        // Smoke test: verify the API can be created
        Assertions.assertNotNull(api);
    }
}
