package streaming;

import org.junit.Test;

public class MaxConsecutiveSum {

    /**
     * Given an array of integers and a number k.
     * Return the highest sum of any k consecutive elements in the array.
     */

    @Test
    public void test() {

    }

    int highestSum(int[] arr, int k) {
        int max = 0;
        int sum = 0;
        for (int i=0; i<arr.length; i++) {
            sum += arr[i];
            if (i>=k) {
                sum -= arr[i-k];
            }
            max = Math.max(max, sum);
        }

        return max;

    }

}
