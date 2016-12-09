package interviewbit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreatestCommonDivisor {

    @Test
    public void test() {
        assertEquals(3, gcd(12, 15));
    }

    public int gcd(int a, int b) {
        while(a!=0 && b!=0) {
            int c = b;
            b = a%b;
            a = c;
        }
        return a+b;
    }

}
