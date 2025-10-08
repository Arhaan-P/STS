import java.util.Scanner;

/*
 MaxProductSubarray.java
 Time: O(n) Space: O(1)
 Computes maximum product subarray in O(n) by maintaining prefix and suffix products
 and handling zeros by resetting to 1 when encountered.
*/
public class MaxProductSubarray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        int pre = 1, suf = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pre == 0)
                pre = 1;
            if (suf == 0)
                suf = 1;
            pre *= arr[i];
            suf *= arr[n - 1 - i];
            ans = Math.max(ans, Math.max(pre, suf));
        }
        System.out.println(ans);
        in.close();
    }
}
