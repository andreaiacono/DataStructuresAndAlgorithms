package dynamicprogramming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// Dynamic programming for coding interviews
// Example 8.4
public class MaxSubarray {

    @Test
    public void testMaxSubarray() {
        int[] values = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        int max = maxSum(values);
        System.out.println(max);
        assertEquals(7, max);

        int[] a = new int[]{0, -1, 2, -3, 5, 9, -5, 10};
        assertEquals(19, maxSum(a));

        a = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, maxSum(a));

        a = new int[]{-2, 1};
        assertEquals(1, maxSum(a));

        a = new int[]{2, -1};
        assertEquals(2, maxSum(a));

        a = new int[]{-1, -1, -1, -1, 1};
        assertEquals(1, maxSum(a));

        a = new int[]{1, -1, -1, -1, -1};
        assertEquals(1, maxSum(a));

        a = new int[]{-1, -1, -1, -1, -1};
        assertEquals(-1, maxSum(a));
    }

    private int maxSum(int[] values) {
        int bestSum = 0;
        int currentSum = 0;
        int absMax = Integer.MIN_VALUE;

        for (int i=0; i<values.length; i++)  {
            currentSum = Math.max(0, currentSum + values[i]);
            bestSum = Math.max(bestSum, currentSum);
            absMax = Math.max(absMax, values[i]);
        }
        return (absMax < 0) ? absMax: bestSum;
    }
}
