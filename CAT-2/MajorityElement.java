import java.util.Scanner;

/*
 MajorityElement.java
 Time: O(n) Space: O(1)
 Implements Boyer-Moore Voting algorithm to find majority element (> n/2 occurrences)
 Two-phase: candidate selection and verification.
*/
public class MajorityElement {
    public static int majorityElement(int[] arr, int n) {
        int count = 0, ele = 0;
        for (int v : arr) {
            if (count == 0) {
                ele = v;
                count = 1;
            } else if (v == ele)
                count++;
            else
                count--;
        }
        int c = 0;
        for (int v : arr)
            if (v == ele)
                c++;
        if (c > n / 2)
            return ele;
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(majorityElement(arr, n));
        sc.close();
    }
}
