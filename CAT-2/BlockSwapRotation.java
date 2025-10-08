import java.util.Scanner;

/*
 BlockSwapRotation.java
 Time: O(n) Space: O(1)
 Performs left rotation of an array by r positions using the Block Swap algorithm.
 The algorithm swaps blocks of elements recursively until rotation is complete. Runs in O(n).
*/
public class BlockSwapRotation {
    static void swap(int arr[], int fi, int si, int r) {
        for (int a = 0; a < r; a++) {
            int temp = arr[fi + a];
            arr[fi + a] = arr[si + a];
            arr[si + a] = temp;
        }
    }

    static void leftRotate(int arr[], int r, int n) {
        if (n == 0)
            return;
        r %= n;
        if (r == 0)
            return;
        int a = r, b = n - r;
        while (a != b) {
            if (a < b) {
                swap(arr, r - a, r + b - a, a);
                b -= a;
            } else {
                swap(arr, r - a, r, b);
                a -= b;
            }
        }
        swap(arr, r - a, r, a);
    }

    static void printArray(int arr[]) {
        for (int v : arr)
            System.out.print(v + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int r = sc.nextInt();
        leftRotate(arr, r, n);
        printArray(arr);
        sc.close();
    }
}
