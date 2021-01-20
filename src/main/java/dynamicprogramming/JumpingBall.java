package dynamicprogramming;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class JumpingBall {


    /**
     * You’re given a flat runway with a bunch of spikes in it. The runway is represented by a boolean array
     * which indicates if a particular (discrete) spot is clear of spikes. It is True for clear and False for
     * not clear.
     * You’re given a starting speed S. S is a non-negative integer at any given point, and it indicates
     * how much you will move forward with the next jump.
     * Every time you land on a spot, you can adjust your speed by up to 1 unit before the next jump.
     * You want to safely stop anywhere along the runway (does not need to be at the end of the array).
     * You stop when your speed becomes 0. However, if you land on a spike at any point, your crazy bouncing ball
     * bursts and it’s game over.
     * <p>
     * The output of your function should be a boolean indicating whether we can safely stop anywhere along the runway.
     * https://medium.com/free-code-camp/follow-these-steps-to-solve-any-dynamic-programming-interview-problem-cc98e508cd0e
     */

    @Test
    public void test() {
        boolean[] runway = new boolean[] { true, false, true, true, true, false, true, true, false, true, true};
        int[][] cache = new int[100][100];
        assertTrue(canStop(runway, 2, 0, cache));
        assertFalse(canStop(runway, 5, 0, cache));
    }

    boolean canStop(boolean[] runway, int speed, int pos, int[][] cache) {

        if (cache[pos][speed] != 0) {
            return cache[pos][speed] == 1;
        }

        if (pos == runway.length || !runway[pos]) {
            return false;
        }

        if (speed == 0) {
            return true;
        }

        boolean result =
                (speed > 0 && canStop(runway, speed - 1, pos + speed, cache)) ||
                canStop(runway, speed, pos + speed, cache) ||
                canStop(runway, speed + 1, pos + speed, cache);
        cache[pos][speed] = result ? 1 : -1;

        return result;
    }
}
