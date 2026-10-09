package project.api;

public class ComputationAPIImpl implements ComputationAPI {

    @Override
    public ComputeResult compute(ComputeRequest request) {
        int n = request.getInputNumber();

        int largestPrime = 0;
        int totalPrimes = 0;

        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                totalPrimes++;

                if (i < n) {
                    largestPrime = i;
                }
            }
        }

        String output = n + ": largest_prime=" + largestPrime
                + " total_primes=" + totalPrimes;

        return new ComputeResult(output);
    }
}