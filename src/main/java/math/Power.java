package math;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Power {

    /***
     * Given a double, x, and an integer, n, write a function to calculate x raised to the power n.
     * https://levelup.gitconnected.com/cracking-the-top-40-facebook-coding-interview-questions-185bab32489f
     */

    @Test
    public void test() {
        assertEquals(8.0, pow(2, 3), 0.00001);
        assertEquals(4.0, pow(2, 2), 0.00001);
        assertEquals(81.0, pow(3, 4), 0.00001);
        assertEquals(3.375, pow(1.5, 3), 0.00001);
        assertEquals(1.0, pow(-21.5, 0), 0.00001);
        assertEquals(0.25, pow(2, -2), 0.00001);
    }

    private double pow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double result = x;
        for (int i=0; i<Math.abs(n)-1; i++) {
            result = result * x;
        }
        return n > 0 ? result : (1 / result);
    }
}
