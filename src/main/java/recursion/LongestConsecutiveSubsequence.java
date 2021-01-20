package recursion;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

public class LongestConsecutiveSubsequence {

    /**
     * Given an array of integers, find the length of the longest sub-sequence such that elements in the subsequence
     * are consecutive integers, the consecutive numbers can be in any order.
     * <p>
     * Examples:
     * <p>
     * Input: arr[] = {1, 9, 3, 10, 4, 20, 2}
     * Output: 4
     * Explanation:
     * The subsequence 1, 3, 4, 2 is the longest
     * subsequence of consecutive elements
     * <p>
     * Input: arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}
     * Output: 5
     * Explanation:
     * The subsequence 36, 35, 33, 34, 32 is the longest
     * subsequence of consecutive elements.
     */

    @Test
    public void test() {
        int[] values = new int[] {1, 9, 3, 10, 4, 20, 2};
        assertEquals(4, lcs(values));

        values = new int[] {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42};
        assertEquals(5, lcs(values));
    }

    private int lcs(int[] values) {
        Set<Integer> vals  = new HashSet<>();
        for (int val: values) {
            vals.add(val);
        }

        int length = 0;
        for (int val: values) {
            if (!vals.contains(val-1)) {
                length = Math.max(length, lcs(vals, val));
            }
        }
        return length;
    }

    private int lcs(Set<Integer> vals, int val) {
        int length = 1;
        while (vals.contains(val+1)) {
            length++;
            val = val + 1;
        }
        return length;
    }

    private int lcsBad(List<Integer> values) {
        int max = 0;
        for (int value : values) {
            max = Math.max(max, lcsBad(values, value));
        }
        return max;
    }

    private int lcsBad(List<Integer> values, int n) {
        int current = n;
        while (true) {
            boolean hasSuccessor = false;
            for (int value : values) {
                 if (value == current + 1) {
                     current ++;
                     hasSuccessor = true;
                     break;
                 }
            }
            if (!hasSuccessor) {
                return current -n + 1;
            }
        }
    }
}
