
package project.checkpointtests;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import project.api.DataStorageAPIImpl;
import project.api.StorageConfig;
import project.api.ComputeResult;

public class TestProcessAPI {

    @Test
    public void testStorage() throws Exception {

        Path input = Files.createTempFile("input", ".txt");
        Path output = Files.createTempFile("output", ".txt");

        try {
            Files.writeString(input, "1\n10\n25");

            DataStorageAPIImpl api = new DataStorageAPIImpl();

            StorageConfig config = new StorageConfig(
                input.toString(),
                output.toString()
            );

            api.readInputData(config);

            Assertions.assertEquals(
                3,
                api.getInputNumbers().size()
            );

            ComputeResult result = new ComputeResult(
                "10: largest_prime=7 total_primes=4"
            );

            api.writeData(config, result);

            Assertions.assertEquals(
                result.getOutput(),
                Files.readString(output)
            );

            Assertions.assertNotNull(api.getLastResult());

        } finally {
            Files.deleteIfExists(input);
            Files.deleteIfExists(output);
        }
    }
}
