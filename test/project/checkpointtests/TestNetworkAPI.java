
package project.checkpointtests;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import project.api.ComputationAPI;
import project.api.ComputeRequest;
import project.api.ComputeResult;
import project.api.DataStorageAPI;
import project.api.InputData;
import project.api.JobConfig;
import project.api.StorageConfig;
import project.api.UserComputeEngineAPIImpl;

public class TestNetworkAPI {

    @Test
    public void testConfigureJob() {

        ComputationAPI computation =
                mock(ComputationAPI.class);

        DataStorageAPI storage =
                mock(DataStorageAPI.class);

        UserComputeEngineAPIImpl api =
                new UserComputeEngineAPIImpl(
                        computation, storage);

        Assertions.assertEquals(
                "Job configured",
                api.configureJob(
                        new JobConfig(
                                "input.txt", "output.txt")));
    }

    @Test
    public void testStartJob() {

        ComputationAPI computation =
                mock(ComputationAPI.class);

        DataStorageAPI storage =
                mock(DataStorageAPI.class);

        when(storage.clearOutput(
                any(StorageConfig.class)))
                .thenReturn("SUCCESS");

        when(storage.readInputData(
                any(StorageConfig.class)))
                .thenReturn(new InputData(List.of(10)));

        when(computation.compute(
                any(ComputeRequest.class)))
                .thenReturn(new ComputeResult(
                        "10: largest_prime=7 total_primes=4"));

        when(storage.writeData(
                any(StorageConfig.class),
                any(ComputeResult.class)))
                .thenReturn("SUCCESS");

        UserComputeEngineAPIImpl api =
                new UserComputeEngineAPIImpl(
                        computation, storage);

        String response =
                api.startJob(
                        new JobConfig(
                                "input.txt", "output.txt"));

        Assertions.assertEquals(
                "Job completed", response);

        verify(storage).clearOutput(
                any(StorageConfig.class));

        verify(storage).readInputData(
                any(StorageConfig.class));

        verify(computation).compute(
                any(ComputeRequest.class));

        verify(storage).writeData(
                any(StorageConfig.class),
                any(ComputeResult.class));
    }

    @Test
    public void testStorageErrorReturnsErrorMessage() {

        ComputationAPI computation =
                mock(ComputationAPI.class);

        DataStorageAPI storage =
                mock(DataStorageAPI.class);

        when(storage.clearOutput(
                any(StorageConfig.class)))
                .thenReturn(
                        "ERROR: Unable to clear output file");

        UserComputeEngineAPIImpl api =
                new UserComputeEngineAPIImpl(
                        computation, storage);

        String response =
                api.startJob(
                        new JobConfig(
                                "input.txt", "output.txt"));

        Assertions.assertTrue(
                response.startsWith("ERROR:"));

        Assertions.assertFalse(
                response.equals("Job completed"));
    }
}
