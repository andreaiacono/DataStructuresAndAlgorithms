package array;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;

public class ArraySort {

    /**
     * Given an array containing only 0,1 and 2, sort the array.
     * <p>
     * Input: 1 1 1 0 2 2 1 0
     * Output: 0 0 1 1 1 1 2 2
     **/

    @Test
    public void test() {

        int[] values = new int[]{1, 1, 1, 0, 2, 2, 1, 0};
        int[] expected = new int[]{0, 0, 1, 1, 1, 1, 2, 2};

        assertArrayEquals(expected, smallSort(values));
    }

    private int[] smallSort(int[] values) {

        int[] result = new int[values.length];
        Map<Integer, Integer> counts = new LinkedHashMap<>();
        counts.put(0, 0);
        counts.put(1, 0);
        counts.put(2, 0);

        for (int val : values) {
            counts.put(val, counts.get(val) + 1);
        }

        int index =0;
        for (Integer number: counts.keySet()) {
            for (int i=0; i<counts.get(number); i++) {
                result[index++] = number;
            }
        }

        return result;
    }

}
