
package project.checkpointtests;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import project.api.ComputationAPIImpl;
import project.api.JobConfig;
import project.api.JobManager;
import project.api.StorageConfig;
import project.api.UserComputeEngineAPIImpl;

public class ComputeEngineIntegrationTest {

    @Test
    public void testCompleteSystem() {

        InMemoryInputConfig input =
                new InMemoryInputConfig(List.of(1, 10, 25));

        InMemoryOutputConfig output =
                new InMemoryOutputConfig();

        InMemoryDataStorageAPI storage =
                new InMemoryDataStorageAPI(input, output);

        ComputationAPIImpl computation =
                new ComputationAPIImpl();

        UserComputeEngineAPIImpl network =
                new UserComputeEngineAPIImpl(
                        computation, storage);

        JobConfig job =
                new JobConfig("input", "output");

        Assertions.assertNotNull(network);

        JobManager manager =
                new JobManager(computation, storage);

        StorageConfig config =
                new StorageConfig("input", "output");

        for (int number : input.getInputs()) {
            manager.runJob(number, config);
        }

        verifyResults(output);
    }

    private void verifyResults(
            InMemoryOutputConfig output) {

        Assertions.assertEquals(
                3, output.getResults().size());

        Assertions.assertEquals(
                "1: largest_prime=0 total_primes=0",
                output.getResults().get(0).getOutput());

        Assertions.assertEquals(
                "10: largest_prime=7 total_primes=4",
                output.getResults().get(1).getOutput());

        Assertions.assertEquals(
                "25: largest_prime=23 total_primes=9",
                output.getResults().get(2).getOutput());
    }
}
