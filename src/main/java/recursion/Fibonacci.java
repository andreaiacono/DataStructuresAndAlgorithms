package recursion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Fibonacci {
    @Test
    public void test() {
        assertEquals(13, fibonacci(7));
        assertEquals(21, fibonacci(8));
        assertEquals(5702887, fibonacci(34));

        assertEquals(13, fibonacciNoSpace(7));
        assertEquals(21, fibonacciNoSpace(8));
        assertEquals(5702887, fibonacciNoSpace(34));
    }

    private int fibonacci(int n) {
        int[] fibs = new int[n+1];
        fibs[0] = 0;
        fibs[1] = 1;
        for (int j=2; j<=n; j++) {
            fibs[j] = fibs[j-1] + fibs[j-2];
        }

        return fibs[n];
    }


    private int fibonacciNoSpace(int n) {
        int back1 = 1;
        int back2 = 0;
        int value = 0;
        for (int j=2; j<=n; j++) {
            value = back1 + back2;
            back2 = back1;
            back1 = value;
        }
        return value;
    }


}
