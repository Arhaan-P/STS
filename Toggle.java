import java.util.Scanner;

public class Toggle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        boolean[] b = new boolean[n + 1];
        int i, j, open = 0, closed = 0;

        // Toggle the doors
        for (i = 1; i <= n; i++) {
            for (j = i; j * i <= n; j++) {
                // Toggle door j*i
                b[j * i] = !b[j * i];
            }
        }

        // Count open and closed doors
        for (i = 1; i <= n; i++) {
            if (b[i]) {
                open++;
            } else {
                closed++;
            }
        }

        System.out.println("No of doors open: " + open);
        System.out.println("No of doors closed: " + closed);

        sc.close();
    }
}
