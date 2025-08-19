public class SieveMain {

    // Function to print all prime numbers up to 'limit'
    public static void simpleSieve(int limit) {
        boolean[] prime = new boolean[limit + 1];

        // Assume all numbers are prime initially
        for (int i = 2; i <= limit; i++) {
            prime[i] = true;
        }

        // Mark multiples of each number starting from 2
        for (int p = 2; p * p <= limit; p++) {
            if (prime[p]) {
                // Mark all multiples of p as non-prime
                for (int i = p * p; i <= limit; i += p) {
                    prime[i] = false;
                }
            }
        }

        // Print all prime numbers
        for (int p = 2; p <= limit; p++) {
            if (prime[p]) {
                System.out.print(p + " ");
            }
        }
    }

    public static void main(String[] args) {
        simpleSieve(50);
    }
}
