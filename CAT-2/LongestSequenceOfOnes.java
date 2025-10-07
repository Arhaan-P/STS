/*
 LongestSequenceOfOnes.java
 Given a binary string, computes the maximum length of consecutive 1s obtainable
 by flipping at most one 0 to 1. The provided logic tracks previous and current runs.
*/
public class LongestSequenceOfOnes {
    public static void main(String[] args) {
        String s = "01101110111";
        int cur = 0, max = 0, pre = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1')
                cur++;
            else {
                max = Math.max(max, pre + cur + 1);
                pre = cur;
                cur = 0;
            }
        }
        max = Math.max(max, pre + cur + 1);
        System.out.println(max);
    }
}
