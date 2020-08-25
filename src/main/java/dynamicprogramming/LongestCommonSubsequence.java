package dynamicprogramming;

import org.junit.Test;

public class LongestCommonSubsequence {

    @Test
    public void test() {

    }

    // sub is shorter than sub
    int lcs(String s1, String sub) {

        if (sub.length() == 0) {
            return 0;
        }

        if (s1.charAt(s1.length()-1) == sub.charAt(sub.length()-1)) {
            return 1 + lcs(s1.substring(0, s1.length()-1), sub.substring(0, sub.length()-1));
        }
        else {
            return Math.max(
                    lcs(s1, sub.substring(1)),
                    lcs(s1, sub.substring(0, sub.length()-1))
            );
        }
    }

    boolean isSub(String s1, String s2) {
        int index = 0;
        for (int i=0; i<s2.length(); i++) {
            char c = s2.charAt(i);
            while (index < s1.length() && c != s1.charAt(index)) {
                index ++;
            }
            if (index == s1.length() && i < s2.length()-1) {
                return false;
            }
        }
        return true;
    }
}
