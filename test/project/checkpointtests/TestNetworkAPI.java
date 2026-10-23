
package project.checkpointtests;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import project.api.ComputationAPI;
import project.api.DataStorageAPI;
import project.api.UserComputeEngineAPIImpl;

public class TestNetworkAPI {

    @Test
    public void testConfigureJob() {

        ComputationAPI computation = mock(ComputationAPI.class);
        DataStorageAPI storage = mock(DataStorageAPI.class);

        UserComputeEngineAPIImpl api =
                new UserComputeEngineAPIImpl(computation, storage);

        Assertions.assertNotNull(api);
    }
}
