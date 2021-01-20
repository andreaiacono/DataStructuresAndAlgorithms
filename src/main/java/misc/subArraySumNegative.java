package misc;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;

public class subArraySumNegative {

    /**
     * Given an unsorted array of nonnegative integers, find a continuous subarray which adds to a given number.
     */

    @Test
    public void test() {
        int[] arr = new int[] {1, 4, 20, 3, 10, 5};
        int sum = 33;
        int[] expected = new int[] {2, 4};
        assertTrue(Arrays.equals(expected, subarraySumNegativeBruteForce(arr, sum)));
        assertTrue(Arrays.equals(expected, subarraySumNegative(arr, sum)));

        arr = new int[]  {10, 2, -2, -20, 10};
        sum = -10;
        expected = new int[] {0, 3};
        assertTrue(Arrays.equals(expected, subarraySumNegativeBruteForce(arr, sum)));
        assertTrue(Arrays.equals(expected, subarraySumNegative(arr, sum)));

        arr = new int[]  {-10, 0, 2, -2, -20, 10};
        sum = 20;
        expected = new int[] {};
        assertTrue(Arrays.equals(expected, subarraySumNegativeBruteForce(arr, sum)));
        assertTrue(Arrays.equals(expected, subarraySumNegative(arr, sum)));
    }

    private int[] subarraySumNegativeBruteForce(int[] arr, int sum) {
        for (int i=0; i<arr.length; i++) {
            int j = i;
            int partial = 0;
            while (partial != sum && j<arr.length) {
                partial += arr[j++];
                if (partial == sum) {
                    return new int[] {i, j-1};
                }
            }
        }

        return new int[] {};
    }

    private int[] subarraySumNegative(int[] arr, int sum) {

        // edge cases
        if (sum == 0 || arr == null || arr.length == 0){
            return new int[] {};
        }

        Map<Integer, Integer> sums = new HashMap<>();
        int partial = 0;
        for (int i=0; i<arr.length; i++) {
            partial += arr[i];

            if (partial == sum) {
                return new int[] { 0, i };
            }
            else if (sums.containsKey(partial - sum)) {
                return new int[] { sums.get(partial - sum) + 1 , i};
            }

            sums.put(partial, i);
        }

        return new int[] {};
    }
}
