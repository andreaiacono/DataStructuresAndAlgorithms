package bit;

import org.junit.Test;

public class Utils {

    @Test
    public void test() {

    }

    boolean isSet(long n, int k) {
        return ((1 << k) & n) != 0;
    }

    long setBit(long n, int k) {
        return (1 << k) | n;
    }

    long clearBit(long n, int k) {
        return ~(1 << k) | n;
    }

    long toggleBit(long n, int k) {
        return (1 << k) ^ n;
    }

    public int hammingWeight(int n) {
        int sum = 0;
        for (int i=0; i<32; i++) {
            int mask = 1;
            if ((mask & n) != 0) {
                sum ++;
                mask <<= 1;
            }
        }
        return sum;
    }
}
