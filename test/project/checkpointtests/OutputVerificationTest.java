
package project.checkpointtests;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import project.api.ComputationAPIImpl;
import project.api.ComputeResult;
import project.api.JobConfig;
import project.api.MultiThreadedUserComputeEngineAPIImpl;
import project.api.UserComputeEngineAPIImpl;

public class OutputVerificationTest {

    @Test
    public void testSingleAndMultiThreadedOutputMatch() {

        List<Integer> numbers = List.of(1, 15, 10, 5, 2, 3, 8);

        InMemoryOutputConfig singleOutput =
                new InMemoryOutputConfig();

        InMemoryDataStorageAPI singleStorage =
                new InMemoryDataStorageAPI(
                        new InMemoryInputConfig(numbers),
                        singleOutput);

        UserComputeEngineAPIImpl singleEngine =
                new UserComputeEngineAPIImpl(
                        new ComputationAPIImpl(),
                        singleStorage);

        String singleStatus = singleEngine.startJob(
                new JobConfig("input", "output"));

        InMemoryOutputConfig multiOutput =
                new InMemoryOutputConfig();

        InMemoryDataStorageAPI multiStorage =
                new InMemoryDataStorageAPI(
                        new InMemoryInputConfig(numbers),
                        multiOutput);

        MultiThreadedUserComputeEngineAPIImpl multiEngine =
                new MultiThreadedUserComputeEngineAPIImpl(
                        new ComputationAPIImpl(),
                        multiStorage);

        String multiStatus = multiEngine.startJob(
                new JobConfig("input", "output"));

        Assertions.assertEquals("Job completed", singleStatus);
        Assertions.assertEquals("Job completed", multiStatus);

        List<String> singleResults =
                getOutputs(singleOutput);

        List<String> multiResults =
                getOutputs(multiOutput);

        Assertions.assertEquals(singleResults, multiResults);
        Assertions.assertEquals(numbers.size(), multiResults.size());
    }

    private List<String> getOutputs(InMemoryOutputConfig output) {

        List<String> results = new ArrayList<>();

        for (ComputeResult result : output.getResults()) {
            results.add(result.getOutput());
        }

        return results;
    }
}
