package misc;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BuddyStrings {

    @Test
    public void test() {
        String s1 = "ab";
        String s2 = "ba";
        assertTrue(buddyStrings(s1, s2));

        s1 = "ab";
        s2 = "ab";
        assertFalse(buddyStrings(s1, s2));

        s1 = "abc";
        s2 = "acb";
        assertTrue(buddyStrings(s1, s2));

        s1 = "aaaa";
        s2 = "aaaa";
        assertTrue(buddyStrings(s1, s2));

        s1 = "aaaab";
        s2 = "caaaa";
        assertTrue(buddyStrings(s1, s2));
    }


    public boolean buddyStrings(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        int index1 = -1;
        int index2 = -1;
        int[] aCounts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            aCounts[c1 - 97]++;
            if (c1 != c2) {
                if (index1 == -1) {
                    index1 = i;
                } else if (index2 == -1) {
                    index2 = i;
                } else {
                    return false;
                }
            }
        }
        boolean hasDuplicates = false;
        for (int i = 0; i < aCounts.length; i++) {
            if (aCounts[i] > 1) {
                hasDuplicates = true;
                break;
            }
        }

        if (!hasDuplicates && (index1 == -1 || index2 == -1)) {
            return false;
        }


        return s1.charAt(index1) == s2.charAt(index2) && s1.charAt(index2) == s2.charAt(index1) || hasDuplicates;
    }
}
