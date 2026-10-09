package project.checkpointtests;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import project.api.*;

public class ComputeEngineIntegrationTest {

    @Test
    public void testCompleteSystem() {
        InMemoryInputConfig input =
                new InMemoryInputConfig(List.of(100));

        InMemoryOutputConfig output =
                new InMemoryOutputConfig();

        InMemoryDataStorageAPI storage =
                new InMemoryDataStorageAPI(input, output);

        ComputationAPIImpl computation =
                new ComputationAPIImpl();

        UserComputeEngineAPIImpl network =
                new UserComputeEngineAPIImpl(computation, storage);

        JobConfig job = new JobConfig("input", "output");

        Assertions.assertEquals(
            "input -> output",
            network.configureJob(job)
        );

        JobManager manager = new JobManager(computation, storage);

        StorageConfig config =
                new StorageConfig("input", "output");

        for (int number : input.getInputs()) {
            manager.runJob(number, config);
        }

        Assertions.assertEquals(1, output.getResults().size());

        Assertions.assertEquals(
            "100: largest_prime=97 total_primes=25",
            output.getResults().get(0).getOutput()
        );
    }
}