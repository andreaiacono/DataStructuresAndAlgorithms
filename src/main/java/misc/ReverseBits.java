package misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseBits {

    @Test
    public void test() {
        assertEquals(5, reverse(10));
    }

    int reverse(int n) {
        return ~n;
    }
}
