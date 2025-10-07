public class Segmented {

    // Function to print all prime numbers in the range [l, h]
    static void SegSieve(int l, int h) {

        // Step 1: create a boolean array for marking
        boolean[] prime = new boolean[h + 1];

        // Step 2: mark all multiples of every number starting from 2
        for (int p = 2; p * p <= h; p++) {
            // Find the smallest multiple of p greater than or equal to l
            int sm = (l / p) * p;
            if (sm < l) {
                sm += p;
            }

            // Mark all multiples of p in the range [l, h]
            for (int i = sm; i <= h; i += p) {
                prime[i] = true;
            }
        }

        // Step 3: print all numbers in [l, h] that are still unmarked
        for (int i = l; i <= h; i++) {
            if (!prime[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        SegSieve(10, 30);
    }
}
