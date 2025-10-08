import java.util.Scanner;

/*
 BoothAlgorithmBinary.java
 Time: O(n*bits) Space: O(bits)
 Implements Booth's multiplication algorithm working with binary strings.
 This version expects two binary strings of equal length. It keeps ACC and Q
 and Q-1 and performs add/sub and arithmetic right shifts.
*/
public class BoothAlgorithmBinary {
    // helper: convert binary string to int array
    static int[] toBinaryArray(String binStr) {
        int[] arr = new int[binStr.length()];
        for (int i = 0; i < binStr.length(); i++) {
            if (binStr.charAt(i) == '1')
                arr[i] = 1;
            else
                arr[i] = 0;
        }
        return arr;
    }

    static void printBinary(int[] arr) {
        for (int b : arr)
            System.out.print(b);
    }

    // binary addition (same length arrays)
    static int[] binaryAdd(int[] a, int[] b) {
        int n = a.length;
        int[] res = new int[n];
        int carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            int sum = a[i] + b[i] + carry;
            res[i] = sum & 1;
            carry = sum >> 1;
        }
        return res;
    }

    // binary subtraction a - b using two's complement (assumes same length)
    static int[] binarySubtract(int[] a, int[] b) {
        int n = b.length;
        int[] bComp = new int[n];
        for (int i = 0; i < n; i++) {
            if (b[i] == 0)
                bComp[i] = 1;
            else
                bComp[i] = 0;
        }
        int[] one = new int[n];
        one[n - 1] = 1;
        bComp = binaryAdd(bComp, one); // two's complement
        return binaryAdd(a, bComp);
    }

    static void arithmeticRightShift(int[] ACC, int[] Q, int[] Q_1) {
        int n = ACC.length;
        int msb = ACC[0];
        int lastQ = Q[Q.length - 1];
        for (int i = Q.length - 1; i > 0; i--)
            Q[i] = Q[i - 1];
        Q[0] = ACC[n - 1];
        for (int i = n - 1; i > 0; i--)
            ACC[i] = ACC[i - 1];
        ACC[0] = msb;
        Q_1[0] = lastQ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter multiplicand (binary): ");
        String Mstr = sc.nextLine().trim();
        System.out.print("Enter multiplier (binary): ");
        String Qstr = sc.nextLine().trim();

        int bits = Math.max(Mstr.length(), Qstr.length());
        // pad left with zeros to equal length
        Mstr = String.format("%" + bits + "s", Mstr).replace(' ', '0');
        Qstr = String.format("%" + bits + "s", Qstr).replace(' ', '0');

        int[] M = toBinaryArray(Mstr);
        int[] Q = toBinaryArray(Qstr);
        int[] minusM = binarySubtract(new int[bits], M);
        int[] ACC = new int[bits];
        int[] Q_1 = new int[1];
        Q_1[0] = 0;

        for (int i = 0; i < bits; i++) {
            int q0 = Q[bits - 1];
            int q_1 = Q_1[0];
            if (q0 == 0 && q_1 == 1)
                ACC = binaryAdd(ACC, M);
            else if (q0 == 1 && q_1 == 0)
                ACC = binaryAdd(ACC, minusM);
            arithmeticRightShift(ACC, Q, Q_1);
        }

        System.out.print("Product (binary): ");
        printBinary(ACC);
        printBinary(Q);
        System.out.println();
        sc.close();
    }
}
