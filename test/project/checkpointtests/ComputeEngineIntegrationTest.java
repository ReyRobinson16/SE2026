
package project.checkpointtests;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import project.api.ComputationAPI;
import project.api.ComputationAPIImpl;
import project.api.ComputeRequest;
import project.api.ComputeResult;
import project.api.DataStorageAPI;
import project.api.InputData;
import project.api.JobConfig;
import project.api.StorageConfig;
import project.api.UserComputeEngineAPIImpl;

public class ComputeEngineIntegrationTest {

    @Test
    public void testCompleteSystem() {
        InMemoryInputConfig input =
                new InMemoryInputConfig(List.of(1, 10, 25));
        InMemoryOutputConfig output = new InMemoryOutputConfig();
        InMemoryDataStorageAPI storage =
                new InMemoryDataStorageAPI(input, output);

        UserComputeEngineAPIImpl network =
                new UserComputeEngineAPIImpl(
                        new ComputationAPIImpl(), storage);

        String response = network.startJob(
                new JobConfig("input", "output"));

        Assertions.assertEquals("Job completed", response);
        verifyResults(output);
    }

    @Test
    public void testExceptionReturnsErrorMessage() {
        InMemoryDataStorageAPI storage = new InMemoryDataStorageAPI(
                new InMemoryInputConfig(List.of(5)),
                new InMemoryOutputConfig());

        ComputationAPI failingComputation = new ComputationAPI() {
            @Override
            public ComputeResult compute(ComputeRequest request) {
                throw new IllegalStateException("integration test failure");
            }
        };

        UserComputeEngineAPIImpl network =
                new UserComputeEngineAPIImpl(failingComputation, storage);

        String response = network.startJob(
                new JobConfig("input", "output"));

        Assertions.assertEquals("ERROR: integration test failure", response);
    }

    @Test
    public void testStorageExceptionReturnsErrorMessage() {
        DataStorageAPI failingStorage = new DataStorageAPI() {
            @Override
            public InputData readInputData(StorageConfig config) {
                throw new IllegalStateException("storage read failure");
            }

            @Override
            public String writeData(StorageConfig config, ComputeResult result) {
                return "SUCCESS";
            }

            @Override
            public String clearOutput(StorageConfig config) {
                return "SUCCESS";
            }
        };

        UserComputeEngineAPIImpl network =
                new UserComputeEngineAPIImpl(
                        new ComputationAPIImpl(), failingStorage);

        String response = network.startJob(
                new JobConfig("input", "output"));

        Assertions.assertEquals("ERROR: storage read failure", response);
    }

    @Test
    public void testStorageErrorReturnsErrorMessage() {
        InMemoryDataStorageAPI storage = new InMemoryDataStorageAPI(
                new InMemoryInputConfig(List.of(5)),
                new InMemoryOutputConfig()) {
            @Override
            public String clearOutput(StorageConfig config) {
                return "ERROR: Storage failure";
            }
        };

        UserComputeEngineAPIImpl network =
                new UserComputeEngineAPIImpl(
                        new ComputationAPIImpl(), storage);

        String response = network.startJob(
                new JobConfig("input", "output"));

        Assertions.assertTrue(response.startsWith("ERROR:"));
        Assertions.assertFalse(response.equals("Job completed"));
    }

    private void verifyResults(InMemoryOutputConfig output) {
        Assertions.assertEquals(3, output.getResults().size());

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
