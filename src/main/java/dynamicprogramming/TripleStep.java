package dynamicprogramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
 * steps at a time. Implement a method to count how many possible ways the child can run up the stairs.
 */
public class TripleStep {

    @Test
    public void test() {
        assertEquals(1, tripleSteps(1));
        assertEquals(2, tripleSteps(2));
        assertEquals(4, tripleSteps(3));
        assertEquals(7, tripleSteps(4));
        assertEquals(13, tripleSteps(5));
    }

    int tripleSteps(int steps) {

        int[] partials = new int[Math.max(4, steps+1)];
        partials[1] = 1;
        partials[2] = 2;
        partials[3] = 4;
        for (int i=4; i<=steps; i++) {
            partials[i] = partials[i-1] + partials[i-2] + partials[i-3] ;
        }

        return partials[steps];
    }
}
