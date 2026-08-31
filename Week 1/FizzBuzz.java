public class FizzBuzz {
    public static void main(String[] args) {
        // Bug 1: Loop should be 1 to 100 inclusive
        for (int i = 0; i < 100; i++) {
            // Bug 2: Missing mod 15 check
            if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                // Bug 3: String spelling typo
                System.out.println("Buzzz");
            } else {
                System.out.println(i);
            }
        }
    }
}