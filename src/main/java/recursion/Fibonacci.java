package recursion;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Fibonacci {
    @Test
    public void test() {

        fibsum(11);

        assertEquals(13, fibonacci(7));
        assertEquals(21, fibonacci(8));
        assertEquals(5702887, fibonacci(34));
        assertEquals(1836311903, fibonacci(46));

        assertEquals(13, fibonacciNoSpace(7));
        assertEquals(21, fibonacciNoSpace(8));
        assertEquals(5702887, fibonacciNoSpace(34));
        assertEquals(1836311903, fibonacciNoSpace(46));
    }

    public int fibsum(int a) {

        if (a < 4) {
            return 1;
        }
        if (a < 4) {
            return 1;
        }

        ArrayList<Integer> fibs = new ArrayList<>();
        fibs.add(1);
        fibs.add(1);
        fibs.add(2);

        ArrayList<Integer> sums = new ArrayList<>();
        sums.add(0);
        sums.add(1);
        sums.add(1);

        // fibs = [1,1,2,3,5,8,13]  -  a = 11
        // i = 3, j=1
        for (int i=3; i<=a; i++) {
            fibs.add( fibs.get(i-1) + fibs.get(i-2));
            sums.add(Integer.MAX_VALUE);
            for (int j=1; j<=i && j<a; j++) {
                if (fibs.get(j)<= i && fibs.get(j) >= 0 && sums.get(i-fibs.get(j)) +1 < sums.get(i)) {
                    sums.set(i, sums.get(i-fibs.get(j)) +1);
                }
            }
        }

        return sums.get(a);
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
