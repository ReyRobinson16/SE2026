
package project.api;

public class ComputationAPIImpl implements ComputationAPI {

    @Override
    public ComputeResult compute(ComputeRequest request) {

        int number = request.getInputNumber();
        int largestPrime = 0;
        int totalPrimes = 0;

        for (int i = 2; i <= number; i++) {
            if (isPrime(i)) {
                totalPrimes++;

                if (i < number) {
                    largestPrime = i;
                }
            }
        }

        String output = number
                + ": largest_prime=" + largestPrime
                + " total_primes=" + totalPrimes;

        return new ComputeResult(output);
    }

    private boolean isPrime(int number) {

        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= number / i; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
