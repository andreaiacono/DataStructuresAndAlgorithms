package recursion;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class EditDistance {

    @Test
    public void test() {
        assertEquals("suday", getLongestCommonSubsequence("saturday", "sunday"));
        assertEquals("suday", getLongestCommonSubsequence("sunday", "saturday"));
        assertEquals("12345678", getLongestCommonSubsequence("123456789", "12312345678"));
        assertEquals("123579", getLongestCommonSubsequence("123456789", "12312579"));
        assertEquals("bao", getLongestCommonSubsequence("baobab", "babbo"));
        assertEquals(3, getEditDistance("sunday", "saturday"));
    }

    public static Set<Character> getDiffChars(String s1, String s2) {
        Set<Character> s1Chars = getChars(s1);
        Set<Character> s2Chars = getChars(s2);
        s1Chars.removeAll(s2Chars);
        if (s1Chars.size() > 0) {
            return s1Chars;
        }
        s1Chars = getChars(s1);
        s2Chars.removeAll(s1Chars);
        return s2Chars;
    }

    private static Set<Character> getChars(String s1) {
        Set<Character> set = new HashSet<>();
        for (int j=0; j<s1.length(); j++) {
            set.add(s1.charAt(j));
        }
        return set;
    }

    private int getEditDistance(String s1, String s2) {

        StringBuilder common = new StringBuilder(getLongestCommonSubsequence(s1, s2));
        int distance = s2.length() - common.length();
        int index = 0;
        int counter = 0;
        while (!common.toString().equals(s2)) {
            if (common.charAt(index) != s2.charAt(index)) {
                common.insert(index, s2.charAt(index));
                counter++;
            }
            index++;
        }

        return distance + counter;
    }

    private static String getLongestCommonSubsequence(String s1, String s2) {
        return getLongestCommonSubsequence(s1, 0, "", s2);

    }

    private static String getLongestCommonSubsequence(String s1, int index, String acc, String dec) {

        if (index >= s1.length()) {
            return acc;
        }

        String longestString = acc;
        int longestLength = acc.length();
        for (int j = 0; j < s1.length(); j++) {
            char c = s1.charAt(j);
            if (dec.indexOf(c) >= 0) {
                String result = getLongestCommonSubsequence(s1, index + 1, c + acc, dec.substring(0, dec.indexOf(c)));
                if (result.length() > longestLength) {
                    longestLength = result.length();
                    longestString = result;
                }
            }
        }

        return longestString;
    }


}
