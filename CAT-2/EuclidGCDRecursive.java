import java.util.Scanner;

/*
 EuclidGCDRecursive.java
 Time: O(log(min(a,b))) Space: O(log(min(a,b)))
 Simple recursive implementation of Euclid's algorithm for GCD: gcd(a,b)=gcd(b,a%b).
*/
public class EuclidGCDRecursive {
    public static int gcd(int a, int b) {
        if (b == 0)
            return Math.abs(a);
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.println(gcd(num1, num2));
        sc.close();
    }
}
