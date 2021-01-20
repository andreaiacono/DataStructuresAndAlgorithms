package bit;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BinaryCheck {

    /**
     * Given three 32-bit integers x, y, and b, return x if b is 1 and y if b is 0,
     * using only mathematical or bit operations. You can assume b can only be 1 or 0.
     */

    @Test
    public void test() {
        assertEquals(10, binaryCheck(10, 20, 1));
        assertEquals(20, binaryCheck(10, 20, 0));
        assertEquals(1, binaryCheck(0, 1, 0));
        assertEquals(0, binaryCheck(0, 1, 1));
    }

    int binaryCheck(int x, int y, int b) {
        int bx = b & 1; // = 1 if b == 1 and = 0 if b == 0
        int by = b ^ 1; // = 0 if b == 1 and = 1 if b == 0
        return bx * x + by * y;
    }


}
