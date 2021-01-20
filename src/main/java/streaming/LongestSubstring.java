package streaming;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

public class LongestSubstring {

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     * Full description at https://leetcode.com/problems/longest-substring-without-repeating-characters/
     */

    @Test
    public void test() {
        String input = "pwwkew";
        assertEquals(3, maxSubstring(input));

        input = "abcabcbb";
        assertEquals(3, maxSubstring(input));

        input = "ABCDBABCB";
        assertEquals(4, maxSubstring(input));

        input = "bbbbb";
        assertEquals(1, maxSubstring(input));
    }

    int maxSubstring(String input) {

        Map<Character, Integer> chars = new HashMap<>();
        int tmpMax = 0;
        int max = 0;
        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if (chars.containsKey(c)) {
                tmpMax = Math.min(tmpMax, i - chars.get(c));
            }
            else {
                tmpMax ++;
            }
            chars.put(c, i);
            max = Math.max(max, tmpMax);
        }

        return max;
    }
}
