package amazon;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountBits {

    /**
     * Write an efficient program to count number of 1s in binary representation of an integer.
     */

    @Test
    public void test() {
        assertEquals(2, countBits(6));
        assertEquals(8, countBits(255));
        assertEquals(0, countBits(0));

        System.out.println("-1: " + Integer.toBinaryString(-1));
        assertEquals(31, countBits(-1));
        System.out.println("-2: " + Integer.toBinaryString(-2));
        assertEquals(30, countBits(-2));
        System.out.println("-3: " + Integer.toBinaryString(-4));
        assertEquals(29, countBits(-4));
    }

    int countBits(int n) {
        int bits =0;
        for (int i=0; i<32; i++) {
            if ( ((1 << i) & n) > 0 ) {
                bits ++;
            }
        }
        return bits;
    }

}
