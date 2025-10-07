/*
 KaratsubaMultiplication.java
 Implements the Karatsuba multiplication algorithm for large integers represented as long.
 Core idea: split each number into halves: x = a*10^m + b, y = c*10^m + d
 Then x*y = ac*10^(2m) + ((a+b)*(c+d) - ac - bd)*10^m + bd
 This reduces the number of recursive multiplications from 4 to 3.
*/
public class KaratsubaMultiplication {

    // compute 10^exp as long (safe for moderate exp)
    private static long pow10(int exp) {
        long p = 1L;
        for (int i = 0; i < exp; i++)
            p *= 10L;
        return p;
    }

    public static long karatsubaMultiply(long x, long y) {
        // Base case: use direct multiplication for small numbers
        if (x < 10 || y < 10) {
            return x * y;
        }

        int n = Math.max(Long.toString(Math.abs(x)).length(), Long.toString(Math.abs(y)).length());
        int half = (n + 1) / 2; // split position

        long pow = pow10(half);

        long a = x / pow;
        long b = x % pow;
        long c = y / pow;
        long d = y % pow;

        long ac = karatsubaMultiply(a, c);
        long bd = karatsubaMultiply(b, d);
        long adbc = karatsubaMultiply(a + b, c + d) - ac - bd;

        return ac * pow10(2 * half) + adbc * pow + bd;
    }

    public static void main(String[] args) {
        long x = 1234L;
        long y = 5678L;
        System.out.println("Karatsuba Multiplication Result: " + karatsubaMultiply(x, y));
    }
}
