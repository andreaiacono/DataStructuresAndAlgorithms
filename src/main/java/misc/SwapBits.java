package misc;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SwapBits {

    @Test
    public void test() {

        assertEquals(9, swapBits(10, 0, 1));
        assertEquals(0, swapBits(0, 0, 1));
        assertEquals(12, swapBits(10, 1, 2));
    }

    int swapBits(int n, int i1, int i2) {
        // get bits
        boolean bit1 = ((n >> i1) & 1) != 0;
        boolean bit2 = ((n >> i2) & 1) != 0;

        if (bit1 == bit2) {
            return n;
        }

        // flip bits
        n = (1 << i1) ^ n;
        n = (1 << i2) ^ n;
        return n;
    }

}
