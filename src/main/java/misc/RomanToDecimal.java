package misc;


import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

public class RomanToDecimal {

    /**
     * Convert Given Roman numeral to integer
     * I -> 1
     * V -> 5
     * X -> 10
     * L -> 50
     * C -> 100
     * D -> 500
     * M -> 1000
     */

    @Test
    public void test() {
        assertEquals(1904, romanToDecimal("MCMIV"));
        assertEquals(27, romanToDecimal("XXVII"));
        assertEquals("XXVII", decimalToRoman(27));
        assertEquals("MCMXC", decimalToRoman(1990));
        assertEquals("MCMIV", decimalToRoman(1904));
    }

    Map<Character, Integer> values = Map.of(
            'M', 1000,
            'D', 500,
            'C', 100,
            'L', 50,
            'X', 10,
            'V', 5,
            'I', 1
    );

    Map<Integer, String> romanDigits = new LinkedHashMap<>() {{
        put(1000, "M");
        put(900, "CM");
        put(500, "D");
        put(400, "CD");
        put(100, "C");
        put(90, "XC");
        put(50, "L");
        put(40, "XL");
        put(10, "X");
        put(9, "IX");
        put(5, "V");
        put(4, "IV");
        put(1, "I");
    }};

    private int romanToDecimal(String roman) {
        int result = 0;
        for (int i = 0; i < roman.length(); i++) {
            int value = values.get(roman.charAt(i));
            if (i < roman.length() - 1 && value < values.get(roman.charAt(i + 1))) {
                result -= value;
            } else {
                result += value;
            }
        }
        return result;
    }

    private String decimalToRoman(int n) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> romanDigit: romanDigits.entrySet()) {
            while (n >= romanDigit.getKey()) {
                n -= romanDigit.getKey();
                result.append(romanDigit.getValue());
            }
        }
        return result.toString();
    }
}