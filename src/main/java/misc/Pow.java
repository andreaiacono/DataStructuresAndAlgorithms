package misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Pow {

    @Test
    public void test() {

        assertEquals(16, pow(2,4));
        assertEquals(27, pow(3,3));

    }

    private int pow(int base, int exponent) {
        if (base == 2) {
            return 2 << exponent-1;
        }
        else {
            int prod = base;
            for (int j=0; j<exponent-1; j++) {
                prod *= base;
            }
            return prod;
        }
    }

}
