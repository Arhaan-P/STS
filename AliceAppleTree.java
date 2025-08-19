import java.util.Scanner;

public class AliceAppleTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int apple = sc.nextInt();
        int cnt = 0;
        int sum = 0;

        // Keep adding apples until the required amount is reached
        while (sum < apple) {
            cnt++;
            sum += 12 * cnt * cnt;
        }

        System.out.println(8 * cnt);
        sc.close();
    }
}
