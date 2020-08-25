package misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestPalindromicSubsequence {

    /**
     * Given a sequence, find the length of the longest palindromic
     * subsequence in it.
     */

    @Test
    public void test() {
        String text = "ABCDCBA";
//        assertEquals(7, lps(text));
//        text = "ABCDDCBA";
//        assertEquals(8, lps(text));
//
//        text = "AAAAAA";
//        assertEquals(6, lps(text));

        text = "ABC";
        assertEquals(1, lps(text));

        text = "ZABCDDCBYU";
        assertEquals(6, lps(text));
    }

    int lps(String text) {
        System.out.println(text);
        if (text.length() <= 1) {
            System.out.println("out with " + text);
            return text.length();
        }

        if (text.charAt(0) == text.charAt(text.length()-1)) {
            return 2 + lps(text.substring(1, text.length()-1));
        }
        else {
            int index = 0;
            while (index < text.length() && text.charAt(index) != text.charAt(text.length()-1)) {
                index++;
            }
            System.out.println("after 1: " + index);
            int left = 1;
            if (! (index == text.length()-1 && text.charAt(index) == text.charAt(text.length()-1))) {
                left = 2 + lps(text.substring(index));
            }
            System.out.println("exiting");
            index = text.length()-1;
            while (index >= 0 && text.charAt(0) != text.charAt(index)) {
                index--;
            }
            int right = 1;
            if (! (index == 0 && text.charAt(index) == text.charAt(0))) {
                right = 2 + lps(text.substring(0, index+1));
            }
            System.out.println("after 2: " + index);

            return Math.max(left, right);
        }
    }
}
