package codingame;

import org.junit.Test;

import java.util.stream.LongStream;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class SumOfDivisors {

    @Test
    public void test() {
        assertEquals(4, getDivisorsSum(2));
        assertEquals(21, getDivisorsSum(5));
        assertEquals(33, getDivisorsSum(6));
        assertEquals(41, getDivisorsSum(7));
    }

    private long getDivisorsSum(long n) {
        return 1 + LongStream.range(2, n+1).map(v-> getDivisorSums(v)).sum();
    }

    private long getDivisorSums(long  n) {
        long sum = 1 + n;
        long range = (int) Math.sqrt(n);
        for (long i=2; i<=range; i++) {
            if (n % i == 0) {
                sum += (i == n/i) ? i : i+n/i;
            }
        }
        return sum;
    }

}