import java.util.Scanner;

/*
 MaxEquilibriumSum.java
 Time: O(n) Space: O(n)
 Reads a line of space-separated integers and finds the maximum "equilibrium" sum where
 prefix (from 0..i) equals suffix (i..n-1). The code computes prefix sums and checks
 positions where prefix == suffix and tracks the maximum such sum.
*/
public class MaxEquilibriumSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            if (!sc.hasNextLine())
                return;
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println(0);
                return;
            }
            String[] tokens = input.split("\\s+");
            int n = tokens.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(tokens[i]);

            int[] prefixSum = new int[n];
            int sum = 0, maxPrefixSuffixSum = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[i];
                prefixSum[i] = sum;
            }

            for (int i = 0; i < n; i++) {
                int prefix = prefixSum[i];
                int suffix;
                if (i > 0)
                    suffix = prefixSum[i - 1];
                else
                    suffix = 0;
                suffix = prefixSum[n - 1] - suffix;
                if (prefix == suffix)
                    maxPrefixSuffixSum = Math.max(maxPrefixSuffixSum, prefix);
            }

            System.out.println(maxPrefixSuffixSum);
        } finally {
            sc.close();
        }
    }
}
