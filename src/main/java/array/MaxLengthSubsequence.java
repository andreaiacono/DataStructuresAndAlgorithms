package array;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MaxLengthSubsequence {

    /**
     * Maximum length subsequence with difference between adjacent elements as either 0 or 1
     */

    @Test
    public void test() {

        int[] arr = new int[] {2, 5, 6, 3, 7, 6, 5, 8};
        int expected = 5;
        assertEquals(expected, mls(arr));
        assertEquals(expected, mlsRec(arr));

        arr = new int[] {-2, -1, 5, -1, 4, 0, 3};
        expected = 4;
        assertEquals(expected, mls(arr));
        assertEquals(expected, mlsRec(arr));
    }

    private int mls(int[] arr) {
        int max = 0;
        for (int i=0; i<arr.length; i++) {

            int currentMax = 1;
            int lastValue = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (Math.abs(arr[j] - lastValue) <= 1) {
                    currentMax ++;
                    lastValue = arr[j];
                }
            }
            max = Math.max(max, currentMax);
        }

        return max;
    }

    private int mlsRec(int[] arr) {
        return mlsRec(arr, 0, null, 1, new int[100][100]);
    }

    private int mlsRec(int[] arr, int index, Integer lastValue, int size, int[][] cache) {

        if (index == arr.length) {
            return size;
        }

        if (lastValue != null && cache[index][lastValue] > 0) {
            return cache[index][lastValue];
        }

        int result = 0;
        for (int i = index; i < arr.length; i++) {
            if (lastValue == null || Math.abs(arr[i] - lastValue) <= 1) {
                result = Math.max(result, mlsRec(arr, i+1, arr[i], size + 1, cache));
            }

        }

        if (lastValue != null) {
            cache[index][lastValue] = result;
        }
        return result;
    }
}
