
package project.checkpointtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import project.api.ComputationAPIImpl;
import project.api.ComputeRequest;

public class PrimeEdgeCaseTest {

    @Test
    public void testNoPrimesBelowTwo() {

        ComputationAPIImpl computation = new ComputationAPIImpl();

        Assertions.assertEquals(
            "2: largest_prime=0 total_primes=1",
            computation.compute(new ComputeRequest(2)).getOutput()
        );
    }
}
