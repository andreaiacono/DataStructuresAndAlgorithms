package misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Parity {

    @Test
    public void test() {
        assertEquals(4, parity(15));
        assertEquals(5, parity(-15));
        assertEquals(3, parity(7));
        assertEquals(2, parity(3));
        assertEquals(0, parity(0));
        assertEquals(3, parity(14));
        assertEquals(2, parity(6));
        assertEquals(1, parity(1));
    }

    int parity(int n) {
        int count = 0;
        int nn = Math.abs(n);
        while (nn > 0) {
            if ( (nn & 1) != 0 ) {
                count ++;
            }
            nn = nn >> 1;
        }

        return count + (n < 0 ? 1 : 0);
    }
}
