package recursion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SmallestSetSum {

    /**
     * Given a list of integers, find the smallest consecutive set of integers that sums up to a given number k
     * https://crunchskills.com/google-interview-questions-for-software-engineering-roles/
     */


    @Test
    public void test() {
        int[] values = new int[] {1, 4, 20, 3, 10, 5};
        assertEquals(3, smallestSubSum(values, 33));

        values = new int[] {1, 4, 0, 0, 3, 10, 5};
        assertEquals(4, smallestSubSum(values, 7));

        values = new int[] {1, 4};
        assertEquals(-1, smallestSubSum(values, 0));

        values = new int[] { 15, 2, 4, 8, 9, 5, 10, 23 };
        assertEquals(1, smallestSubSum(values, 23));
    }

    int smallestSubSum(int[] values, int target) {
        int smallest = Integer.MAX_VALUE;
        for (int i=0; i<values.length; i++) {
            int sum = values[i];
            if (sum == target) {
                return 1;
            }
            for (int j=i+1; j<values.length; j++) {
                sum += values[j];
                if (sum == target) {
                    smallest = Math.min(smallest, j - i + 1);
                }
            }
        }
        return smallest == Integer.MAX_VALUE ? -1 : smallest;
    }
}
