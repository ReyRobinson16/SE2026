package project.checkpointtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import project.api.JobConfig;
import project.api.UserComputeEngineAPI;
import project.api.UserComputeEngineAPIImpl;

public class TestNetworkAPI {
    @Test
    public void testNetworkAPISmoke() {
        UserComputeEngineAPI api = new UserComputeEngineAPIImpl();
        JobConfig config = new JobConfig("in.csv", "out.csv", ';');
        String result = api.configureJob(config);
        Assertions.assertNotNull(result);
    }
}