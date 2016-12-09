package interviewbit;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by andrea on 05/12/16.
 */
public class RomanNumbers {

    Map<Character, Integer> vals = new HashMap<Character, Integer>() {{
        put('M', 1000);
        put('D', 500);
        put('C', 100);
        put('L', 50);
        put('X', 10);
        put('V', 5);
        put('I', 1);
    }};



    @Test
    public void test() {
        assertEquals(1, romanToInt("I"));
        assertEquals(4, romanToInt("IV"));
        assertEquals(5, romanToInt("V"));
        assertEquals(40, romanToInt("XL"));
        assertEquals(60, romanToInt("LX"));
        assertEquals(90, romanToInt("XC"));
        assertEquals(99, romanToInt("XCIX"));
        assertEquals(1973, romanToInt("MCMLXXIII"));
        assertEquals(2016, romanToInt("MMXVI"));
    }

    public int romanToInt(String a) {

        int sum = 0;
        for (int i=a.length()-1; i >= 0; i--) {
            if (i-1 >=0 && vals.get(a.charAt(i-1)) < vals.get(a.charAt(i))) {
                sum += vals.get(a.charAt(i)) - vals.get(a.charAt(i-1));
                i--;
            }
            else {
                sum += vals.get(a.charAt(i));
            }
        }

        return sum;
    }

}
