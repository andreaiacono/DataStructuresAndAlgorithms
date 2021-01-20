package streaming;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MaxSumStreaming {


    @Test
    public void test() {
        assertEquals(-1, maxSum(-1));
        assertEquals(0, maxSum(0));
        assertEquals(2, maxSum(2));
        assertEquals(5, maxSum(3));
        assertEquals(5, maxSum(-10));
        assertEquals(5, maxSum(5));
        assertEquals(9, maxSum(4));
        assertEquals(13, maxSum(4));
        assertEquals(13, maxSum(0));
        assertEquals(13, maxSum(-1));
        assertEquals(13, maxSum(-10));
    }

    int tmpSum = 0;
    int maxSum = 0;
    int maxValue = Integer.MIN_VALUE;

    int maxSum(int n) {
        tmpSum = Math.max(0, tmpSum + n);
        maxSum = Math.max(maxSum, tmpSum);
        maxValue = Math.max(maxValue, n);
        return maxValue < 0 ? maxValue : maxSum;
    }


}
