import java.util.Scanner;

public class BinaryPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int n = (int) (Math.log(num) / Math.log(2)) + 1;
        boolean flag = true;

        int left = 0, right = n - 1;

        while (left < right) {
            if (((num >> left) & 1) != ((num >> right) & 1)) {
                System.out.println("no");
                flag = false;
                break;
            }
            left++;
            right--;
        }

        if (flag) {
            System.out.println("yes");
        }
        sc.close();
    }
}
