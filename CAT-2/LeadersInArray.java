import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 LeadersInArray.java
 Time: O(N) Space: O(N)
 For each test case reads N and N integers and prints the leaders in the array.
 A leader is an element greater than or equal to all elements to its right.
 The algorithm scans from right-to-left keeping current maximum; O(N) time.
*/
public class LeadersInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        List<Integer> leaders = new ArrayList<>();
        if (N > 0) {
            int max = arr[N - 1];
            leaders.add(max);
            for (int i = N - 2; i >= 0; i--) {
                if (arr[i] >= max) {
                    leaders.add(arr[i]);
                    max = arr[i];
                }
            }
        }

        for (int i = leaders.size() - 1; i >= 0; i--) {
            if (i == 0)
                System.out.print(leaders.get(i));
            else
                System.out.print(leaders.get(i) + " ");
        }
        System.out.println();
        sc.close();
    }
}