
package project.checkpointtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import project.api.ComputationAPIImpl;
import project.api.ComputeRequest;
import project.api.ComputeResult;

public class TestConceptualAPI {

    @Test
    public void testComputationAPI() {

        ComputationAPIImpl api = new ComputationAPIImpl();

        ComputeRequest request = new ComputeRequest(10);
        ComputeResult result = api.compute(request);

        Assertions.assertNotNull(api);
        Assertions.assertNotNull(result);

        Assertions.assertEquals(
            "10: largest_prime=7 total_primes=4",
            result.getOutput()
        );
    }
}
