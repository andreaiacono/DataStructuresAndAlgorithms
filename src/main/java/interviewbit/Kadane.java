package interviewbit;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class Kadane {

    @Test
    public void test() {
        int[] a = new int[]{0, -1, 2, -3, 5, 9, -5, 10};
        int[] result = new int[]{5, 9, -5, 10};
        assertTrue(Arrays.equals(result, maxSubArray(a)));

        a = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        result = new int[]{4, -1, 2, 1};
        assertTrue(Arrays.equals(result, maxSubArray(a)));

        a = new int[]{-2, 1};
        result = new int[]{1};
        assertTrue(Arrays.equals(result, maxSubArray(a)));

        a = new int[]{2, -1};
        result = new int[]{2};
        assertTrue(Arrays.equals(result, maxSubArray(a)));
    }


    int[] maxSubArray(int[] a) {

        if (a == null) {
            return new int[]{};
        }
        if (a.length == 1) {
            return new int[]{a[0]};
        }

        int globalMax = a[0];
        int partialMax = a[0];
        int start = 0;
        int end = 0;

        for (int i = 1; i < a.length; i++) {
            int partialStart = -1;

//            if (a[i] > partialMax + a[i]) {
            if (partialMax <0) {
                partialStart = i;
                partialMax = a[i];
            }
            else {
                partialMax += a[i];
            }

            if (globalMax < partialMax) {
                globalMax = partialMax;
                if (partialStart != -1) {
                    start = partialStart;
                }
                end = i;
            }
        }

        return Arrays.copyOfRange(a, start, end + 1);
    }

}
