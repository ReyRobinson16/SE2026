
package project.checkpointtests;

<<<<<<< Updated upstream
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import project.api.JobConfig;
=======
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import project.api.ComputationAPI;
import project.api.DataStorageAPI;
>>>>>>> Stashed changes
import project.api.UserComputeEngineAPIImpl;

public class TestNetworkAPI {

    @Test
<<<<<<< Updated upstream
    public void testConfigureJob() {
        UserComputeEngineAPIImpl api =
                new UserComputeEngineAPIImpl();

        JobConfig config = new JobConfig("input", "output");

        String result = api.configureJob(config);

        Assertions.assertEquals("input -> output", result);
=======
    public void testConstructionWithMockDependencies() {

        ComputationAPI computation =
                mock(ComputationAPI.class);

        DataStorageAPI storage =
                mock(DataStorageAPI.class);

        UserComputeEngineAPIImpl api =
                new UserComputeEngineAPIImpl(
                        computation,
                        storage
                );

        Assertions.assertNotNull(api);
>>>>>>> Stashed changes
    }
}
