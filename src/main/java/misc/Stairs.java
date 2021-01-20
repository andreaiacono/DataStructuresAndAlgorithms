package misc;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Stairs {

    /**
     * You are climbing a stair case and it takes A steps to reach to the top.
     * <p>
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     */

    @Test
    public void test() {
        assertEquals(1, stairs(1));
        assertEquals(2, stairs(2));
        assertEquals(3, stairs(3));
        assertEquals(5, stairs(4));
        assertEquals(1, stairs2(1));
        assertEquals(2, stairs2(2));
        assertEquals(3, stairs2(3));
        assertEquals(5, stairs2(4));
    }

    private int stairs2(int steps) {

        if (steps <= 0) {
            return steps == 0 ? 1 : 0;
        }

        return stairs2(steps - 1) + stairs2(steps - 2);
    }

    private int stairs(int steps) {

        int first = 1;
        int second = 0;
        int value = 0;

        for (int i = 0; i<steps; i++) {
            value = first + second;
            second = first;
            first = value;
        }
        return value;
    }
}
