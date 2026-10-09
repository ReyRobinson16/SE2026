package project.checkpointtests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import project.api.*;

public class TestConceptualAPI {

    @Test
    public void testPrimeComputation() {
        ComputationAPIImpl api = new ComputationAPIImpl();

        ComputeResult result = api.compute(new ComputeRequest(100));

        Assertions.assertEquals(
            "100: largest_prime=97 total_primes=25",
            result.getOutput()
        );
    }

    @Test
    public void testSmallPrime() {
        ComputationAPIImpl api = new ComputationAPIImpl();

        ComputeResult result = api.compute(new ComputeRequest(10));

        Assertions.assertEquals(
            "10: largest_prime=7 total_primes=4",
            result.getOutput()
        );
    }

    @Test
    public void testPrimeInput() {
        ComputationAPIImpl api = new ComputationAPIImpl();

        ComputeResult result = api.compute(new ComputeRequest(101));

        Assertions.assertEquals(
            "101: largest_prime=97 total_primes=26",
            result.getOutput()
        );
    }

    @Test
    public void testInvalidInput() {
        ComputationAPIImpl api = new ComputationAPIImpl();

        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> api.compute(new ComputeRequest(0))
        );
    }
}