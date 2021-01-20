package misc;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class HasPermutations {


    /**
     * Given a string, determine whether any permutation of it is a palindrome.
     *
     * For example, carrace should return true, since it can be rearranged to form racecar,
     * which is a palindrome. daily should return false, since there's no rearrangement
     * that can form a palindrome.
     */

    @Test
    public void test() {
        String s = "carrac";
        assertTrue(hasPalindromePermutation(s));

        s = "carrace";
        assertTrue(hasPalindromePermutation(s));

        s = "carraced";
        assertFalse(hasPalindromePermutation(s));

        s = "ca";
        assertFalse(hasPalindromePermutation(s));

        s = "c";
        assertTrue(hasPalindromePermutation(s));

        s = "cccccc";
        assertTrue(hasPalindromePermutation(s));
    }

    boolean hasPalindromePermutationBinary(String s) {
        int val = 0;
        for (int i=0; i<s.length(); i++) {
            val = val ^ s.charAt(i);
        }
        if  (val == 0) {
            return true;
        }
        return val >= 97 && val <= 123;
    }

    boolean hasPalindromePermutation(String s) {
        Set<Character> chars = new HashSet<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (chars.contains(c)) {
                chars.remove(c);
            }
            else {
                chars.add(c);
            }
        }
        return chars.size() < 2;
    }


}
