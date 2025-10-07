import java.util.Scanner;

/*
 SwapNibbles.java
 Demonstrates swapping the two 4-bit nibbles in a byte value (0..255).
 Uses bit masking and shifts: lower nibble (x & 0x0F) and upper nibble (x & 0xF0).
*/
public class SwapNibbles {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            if (!in.hasNextInt()) {
                System.out.println("No input");
                return;
            }
            int x = in.nextInt();
            if (x < 0 || x > 255) {
                System.out.println("Can't Swap");
            } else {
                int result = ((x & 0x0F) << 4) | ((x & 0xF0) >> 4);
                System.out.println(result);
            }
        } finally {
            in.close();
        }
    }
}
