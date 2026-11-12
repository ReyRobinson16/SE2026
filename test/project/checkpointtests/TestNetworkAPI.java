
package project.checkpointtests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import project.api.ComputationAPI;
import project.api.ComputeRequest;
import project.api.ComputeResult;
import project.api.DataStorageAPI;
import project.api.InputData;
import project.api.JobConfig;
import project.api.UserComputeEngineAPIImpl;

import java.util.List;

public class TestNetworkAPI {

    @Test
    public void testConfigureJob() {

        ComputationAPI computation = mock(ComputationAPI.class);
        DataStorageAPI storage = mock(DataStorageAPI.class);

        UserComputeEngineAPIImpl api =
                new UserComputeEngineAPIImpl(computation, storage);

        Assertions.assertEquals(
                "input.txt -> output.txt",
                api.configureJob(
                        new JobConfig("input.txt", "output.txt")));
    }

    @Test
    public void testStartJob() {

        ComputationAPI computation = mock(ComputationAPI.class);
        DataStorageAPI storage = mock(DataStorageAPI.class);

        when(storage.readInputData(
                org.mockito.ArgumentMatchers.any()))
                .thenReturn(new InputData(List.of(10)));

        when(computation.compute(
                org.mockito.ArgumentMatchers.any(ComputeRequest.class)))
                .thenReturn(new ComputeResult(
                        "10: largest_prime=7 total_primes=4"));

        UserComputeEngineAPIImpl api =
                new UserComputeEngineAPIImpl(computation, storage);

        Assertions.assertEquals(
                "Job completed",
                api.startJob(
                        new JobConfig("input.txt", "output.txt")));
    }
}
