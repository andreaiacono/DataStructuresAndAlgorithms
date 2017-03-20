package misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxAreaHistogram {

    @Test
    public void test() {
        int[] input = new int[] {6,2,5,4,5,1,6};
        assertEquals(12, getMaxArea(input));
    }

    int getMaxArea(int[] input) {

        int maxArea = input[0];
        int start = 0;
        int minHeight = input[0];
        for (int i=0; i<input.length-1; i++) {
            minHeight = Math.min(minHeight, input[i]);
            int area = (i - start + 1) * minHeight;
            maxArea = Math.max(maxArea, area);
            if (input[i] < input[i+1] + 1) {
                minHeight = input[i+1];
                start = i+1;
            }
        }

        return maxArea;
    }

    int getMaxAreaBruteForce(int[] input) {

        int max = 0;
        for (int i=0; i<input.length; i++) {
            for (int j=i+1; j< input.length; j++) {

                int area = (j-i+1) * getMin(input, i, j);
                max = Math.max(max, area);

            }
        }

        return max;
    }

    private int getMin(int[] input, int start, int end) {

        int min = Integer.MAX_VALUE;
        for (int i= start; i<= end; i++) {
            min = Math.min(min, input[i]);
        }
        return min;
    }
}
