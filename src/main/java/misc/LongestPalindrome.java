package misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestPalindrome {

    @Test
    public void test() {
        assertEquals(0, getLongestPalindrome(""));
        assertEquals(1, getLongestPalindrome("a"));
        assertEquals(2, getLongestPalindrome("aa"));
        assertEquals(3, getLongestPalindrome("aba"));
        assertEquals(4, getLongestPalindrome("abba"));
        assertEquals(3, getLongestPalindrome("abac"));
        assertEquals(3, getLongestPalindrome("caba"));
        assertEquals(3, getLongestPalindrome("cabad"));
        assertEquals(3, getLongestPalindrome("cdefaba"));
        assertEquals(3, getLongestPalindrome("abacdef"));
    }

    int getLongestPalindrome(String s) {

        int maxLength = 0;

        for (int i=0; i<s.length(); i++) {
            for (int j=0; j < s.length() - i; j++) {
                String substring = s.substring(i, s.length() - j);
                if (isPalindrome(substring) && maxLength < substring.length()) {
                    maxLength = substring.length();
                }
            }
        }

        return maxLength;
    }

    boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }

}
