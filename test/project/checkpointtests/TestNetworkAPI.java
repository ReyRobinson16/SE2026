
package project.checkpointtests;

import static org.mockito.Mockito.mock;
import project.api.JobConfig;

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

        Assertions.assertEquals("input.txt -> output.txt",
                api.configureJob(new JobConfig("input.txt", "output.txt")));
    }
}
