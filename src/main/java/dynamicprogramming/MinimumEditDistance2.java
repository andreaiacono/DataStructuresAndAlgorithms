package dynamicprogramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


// Dynamic programming for coding interviews
// Example 9.1
public class MinimumEditDistance2 {

    @Test
    public void test() {
        assertEquals(2, med("cat", "cars"));
        assertEquals(1, med("cat", "cut"));
        assertEquals(2, med("mad", "hat"));
        assertEquals(3, med("sunday", "saturday"));
        assertEquals(1, med("abcdefghijklm", "abcdefghijklmn"));
    }

    private int med(String s1, String s2) {
        return s1.length() > s2.length() ? med(s1, s2, 0, 0) : med(s2, s1, 0, 0);
    }

    private int med(String s1, String s2, int index, int score) {
        if (s1.equals(s2)) {
            return score;
        }
        if (index >= s1.length() || index >= s2.length()) {
            return Integer.MAX_VALUE;
        }
        if (s1.charAt(index) == s2.charAt(index)) {
            return med(s1, s2, index+1, score);
        }
        int delete = med(s1.substring(1), s2, index+1, score + 1);
        int insert = med(s2.charAt(index) + s1, s2, index+1, score + 1);
        int edit = med(s2.charAt(index) + s1.substring(1), s2, index+1, score + 1);
        return Math.min(delete, Math.min(insert, edit));
    }

}
