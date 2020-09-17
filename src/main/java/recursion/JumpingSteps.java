package recursion;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class JumpingSteps {

    /**
     * You are given an array of integers, where each element represents the maximum
     * number of steps that can be jumped going forward from that element. Write a
     * function to return the minimum number of jumps you must take in order to get
     * from the start to the end of the array.
     *
     * For example, given [6, 2, 4, 0, 5, 1, 1, 4, 2, 9], you should return 2, as the
     * optimal solution involves jumping from 6 to 5, and then from 5 to 9.
     */

    @Test
    public void test() {
        int[] steps = new int[] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        assertEquals(2, minJumps(steps, 1, steps[0], 0, new int[steps.length][steps.length]));
    }

    int minJumps(int[] steps, int from, int to, int jumps, int[][] cache) {

        // base case
        if (to >= steps.length - 1) {
            return jumps;
        }

        if (cache[from][to] > 0) {
            return cache[from][to];
        }

        int result = Integer.MAX_VALUE;
        for (int i=from;i<to; i++) {
            result = Math.min(result, minJumps(steps, from + 1 ,from + 2 + steps[i], jumps+1, cache));
        }

        cache[from][to] = result;
        return result;
    }

}
