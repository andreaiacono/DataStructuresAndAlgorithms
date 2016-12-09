package interviewbit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestPalindrome {



    @Test
    public void test() {
        assertEquals("bb", longestPalindrome("bb"));
        assertEquals("bb", longestPalindrome("abb"));
        assertEquals("anana", longestPalindrome("banana"));
        assertEquals("aaabaaa", longestPalindrome("aaaabaaa"));
        assertEquals("aaabaaa", longestPalindrome("aaabaaa"));
        assertEquals("anaana", longestPalindrome("banaana"));
        assertEquals("a", longestPalindrome("abcde"));
        assertEquals("cdc", longestPalindrome("abcdc"));
        assertEquals("aba", longestPalindrome("abacde"));
        assertEquals("aba", longestPalindrome("abcabade"));

        assertEquals("anana", getLongestPalindrome("banana"));
        assertEquals("a", getLongestPalindrome("abcde"));
        assertEquals("cdc", getLongestPalindrome("abcdc"));
        assertEquals("aba", getLongestPalindrome("abacde"));
        assertEquals("aba", getLongestPalindrome("abcabade"));
    }
    
    /**
     *  This algo has a cubic runtime complexity
     */
    String getLongestPalindrome(String a) {

        if (a.length() == 1) {
            return a;
        }

        int max = 1;
        String result = null;

        for (int i=0; i< a.length(); i++) {
            for (int j=i+1; j< a.length(); j++) {
                String substring = a.substring(i, j+1);
                if (isPalindrome(substring) && j-i+1 > max) {
                    max = j-i+1;
                    result = substring;
                }
            }
        }

        if (max == 1) {
            return a.substring(0, 1);
        }
        return result;
    }
    
    public String longestPalindrome(String a) {

        if (a.length() == 1) {
            return a;
        }

        String result = null;
        int maxPalindrome = 1;
        for (int i=0; i<a.length()*2-1; i++) {

            if (i % 2 == 0) {
                int center = i / 2;
                int maxLength = Math.min(center, a.length()-center-1);
                int index = 1;
                while (index <= maxLength) {
                    String substring = a.substring(center-index, center+index+1);
                    if (isPalindrome(substring)) {
                        if (substring.length() > maxPalindrome) {
                            maxPalindrome = substring.length();
                            result = substring;
                        }
                    }
                    else {
                        break;
                    }
                    index ++;
                }
            }
            else {
                int center = i;
                int maxLength = Math.min(center/2+1, (a.length()*2-center)/2);
                int index = 1;
                while (index <= maxLength) {
                    String substring = a.substring(center/2 +1 -index, center/2 +index+1);
                    if (isPalindrome(substring)) {
                        if (substring.length() > maxPalindrome) {
                            maxPalindrome = substring.length();
                            result = substring;
                        }
                    }
                    else {
                        break;
                    }
                    index ++;
                }

            }
        }

        if (maxPalindrome == 1) {
            return a.substring(0, 1);
        }
        return result;
    }

    boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
