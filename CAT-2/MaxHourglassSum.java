import java.util.Scanner;

/*
 MaxHourglassSum.java
 Computes maximum hourglass sum in a matrix. An hourglass is shape:
 a b c
  1
 d e f
 Requires rows>=3 and cols>=3.
*/
public class MaxHourglassSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] mat = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                mat[i][j] = sc.nextInt();

        if (rows < 3 || cols < 3) {
            System.out.println("Hourglass not possible");
            sc.close();
            return;
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                int sum = mat[i][j] + mat[i][j + 1] + mat[i][j + 2]
                        + mat[i + 1][j + 1]
                        + mat[i + 2][j] + mat[i + 2][j + 1] + mat[i + 2][j + 2];
                maxSum = Math.max(maxSum, sum);
            }
        }

        System.out.println(maxSum);
        sc.close();
    }
}
