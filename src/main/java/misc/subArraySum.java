package misc;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;

public class subArraySum {

    /**
     * Given an unsorted array of nonnegative integers, find a continuous subarray which adds to a given number.
     */

    @Test
    public void test() {
        int[] arr = new int[] {1, 4, 20, 3, 10, 5};
        int sum = 33;
        int[] expected = new int[] {2, 4};
        assertTrue(Arrays.equals(expected, subarraySumBruteForce(arr, sum)));
        assertTrue(Arrays.equals(expected, subarraySum(arr, sum)));

        arr = new int[]  {1, 4, 0, 0, 3, 10, 5};
        sum = 7;
        expected = new int[] {1, 4};
        assertTrue(Arrays.equals(expected, subarraySumBruteForce(arr, sum)));
        assertTrue(Arrays.equals(expected, subarraySum(arr, sum)));

        arr = new int[]  {1, 4};
        sum = 0;
        expected = new int[] {};
        assertTrue(Arrays.equals(expected, subarraySumBruteForce(arr, sum)));
        assertTrue(Arrays.equals(expected, subarraySum(arr, sum)));
    }

    private int[] subarraySumBruteForce(int[] arr, int sum) {
        for (int i=0; i<arr.length; i++) {
            int j = i;
            int partial = 0;
            while (partial <= sum && j<arr.length) {
                partial += arr[j++];
                if (partial == sum) {
                    return new int[] {i, j-1};
                }
            }
        }

        return new int[] {};
    }

    private int[] subarraySum(int[] arr, int sum) {

        // edge cases
        if (sum == 0 || arr == null || arr.length == 0){
            return new int[] {};
        }

        int left = 0;
        int right = 0;
        int partial = arr[0];

        while (right < arr.length ) {

            if (partial == sum) {
                return new int[] {left, right};
            }
            if (partial < sum) {
                right ++;
                partial += arr[right];
            }
            else {
                partial -= arr[left];
                left++;
                if (left > right) {
                    right = left;
                }
            }
        }

        return new int[] {};
    }
}
