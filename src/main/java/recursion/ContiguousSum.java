package recursion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContiguousSum {

    @Test
    public void test() {
        int n[] = new int[]{2, -8, 3, 11, 2, -1, 8};
        assertEquals(23, contiguousSum(n));

        n = new int[]{1, 2, -5};
        assertEquals(3, contiguousSum(n));

        n = new int[]{ -11, 2, 5};
        assertEquals(7, contiguousSum(n));
    }

    public int contiguousSum(int[] n) {
        return contiguousSum(n, 0);
    }

    private int contiguousSum(int[] n, int index) {
        if (index == n.length) {
            return Integer.MIN_VALUE;
        }

        int max = Integer.MIN_VALUE;

        for (int j = index; j < n.length; j++) {
            int sum = sum(n, index, j);
            if (sum > max) {
                max = sum;
            }
        }

        int smallerSetSum = contiguousSum(n, index+1);
        if (smallerSetSum > max) {
            return smallerSetSum;
        }

        return max;
    }


    private int sum(int[] n, int left, int right) {
        int sum = 0;
        for (int j = left; j <= right; j++) {
            sum += n[j];
        }
        return sum;
    }

}
