import java.util.Scanner;

class ChineseRemainder {

    // Method to calculate the solution using brute force
    int calculate(int size, int[] div, int[] rem) {
        int x = 1;

        while (true) {
            int j;
            for (j = 0; j < size; j++) {
                if (x % div[j] != rem[j]) {
                    break;
                }
            }
            if (j == size) {
                return x;
            }
            x++;
        }
    }
}

public class ChineseRemainderTheorem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of divisors: ");
        int size = sc.nextInt();

        int[] div = new int[size];
        System.out.println("Enter the divisors:");
        for (int i = 0; i < size; i++) {
            div[i] = sc.nextInt();
        }

        int[] rem = new int[size];
        System.out.println("Enter the remainders:");
        for (int i = 0; i < size; i++) {
            rem[i] = sc.nextInt();
        }

        ChineseRemainder c = new ChineseRemainder();
        System.out.println("Result = " + c.calculate(size, div, rem));

        sc.close();
    }
}
