package project.checkpointtests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import project.api.*;

public class TestNetworkAPI {

    @Test
    public void testConfigureJob() {
        UserComputeEngineAPIImpl api =
                new UserComputeEngineAPIImpl();

        JobConfig config = new JobConfig("input", "output");

        String result = api.configureJob(config);

        Assertions.assertEquals("input -> output", result);
    }
}