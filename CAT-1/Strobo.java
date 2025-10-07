import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Strobo {

    // Function to check if a number is strobogrammatic
    static boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');

        int left = 0;
        int right = num.length() - 1;

        while (left <= right) {
            char cLeft = num.charAt(left);
            char cRight = num.charAt(right);

            // If left char does not have a valid mapping
            if (!map.containsKey(cLeft)) {
                return false;
            }

            // Check if mapped value of left char equals the right char
            if (map.get(cLeft) != cRight) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Give num : ");
        String n = sc.next();
        System.out.println(isStrobogrammatic(n));
        sc.close();
    }
}
