import java.util.Scanner;

/*
 LexicographicallyFirstPalindrome.java
 Given a string, produce the lexicographically smallest palindrome that can be formed using
 all characters of the string (if possible). Approach: count frequencies, ensure at most one odd
 frequency (for odd length), build first half using smallest characters first.
*/
public class LexicographicallyFirstPalindrome {
    public static boolean canMakePalindrome(int[] freq, int len) {
        int odd = 0;
        for (int f : freq)
            if ((f & 1) != 0)
                odd++;
        return (len % 2 == 0) ? odd == 0 : odd == 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine().toLowerCase();
        int len = s.length();
        int[] freq = new int[26];
        for (char ch : s.toCharArray())
            if (ch >= 'a' && ch <= 'z')
                freq[ch - 'a']++;

        if (!canMakePalindrome(freq, len)) {
            System.out.println("No palindromic string");
            sc.close();
            return;
        }

        StringBuilder odd = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) != 0) {
                freq[i]--; // use one as center
                odd.append((char) ('a' + i));
            }
        }

        StringBuilder first = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i] / 2; j++)
                first.append((char) ('a' + i));
        }
        String second = first.reverse().toString();
        first.reverse(); // restore

        System.out.println("Palindromic string: " + first.toString() + odd.toString() + second);
        sc.close();
    }
}
