package misc;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class LongestDistinctSubarray {

    /**
     * Write a program that takes as input an array and returns
     * the length of the longest sub-array with the property that
     * all its elements are distinct.
     */


    @Test
    public void test() {
        String test = "fsfetwenwe";
        assertEquals(5, lds(test));

        test = "fsfetenwe";
        assertEquals(4, lds(test));

        test = "fs";
        assertEquals(2, lds(test));

        test = "fss";
        assertEquals(2, lds(test));

        test = "ffs";
        assertEquals(2, lds(test));

        test = "ffss";
        assertEquals(2, lds(test));

        test = "f";
        assertEquals(1, lds(test));

        test = "ff";
        assertEquals(1, lds(test));

        test = "abcdefg";
        assertEquals(7, lds(test));
    }

    int lds(String s) {
        int maxLength = 0;
        int leftIndex = 0;
        Map<Character, Integer> positions = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (positions.containsKey(c)) {
                leftIndex = positions.get(c) + 1;
            }
            positions.put(c, i);
            maxLength = Math.max(maxLength, i-leftIndex + 1);
        }

        return maxLength;


    }
}
