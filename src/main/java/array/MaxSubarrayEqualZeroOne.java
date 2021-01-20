package array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class MaxSubarrayEqualZeroOne {

    @Test
    public void test() {
        List<Integer> values = List.of(1, 2, 3, 4);

        values = List.of(0, 0, 1, 0, 1, 1);
        assertEquals(6, maxSubArraySlow(values));
        assertEquals(6, maxSubArray(values));

        values = List.of(0, 0, 1, 0, 1, 0);
        assertEquals(4, maxSubArraySlow(values));
        assertEquals(4, maxSubArray(values));

        values = List.of(0, 0, 0, 0);
        assertEquals(0, maxSubArraySlow(values));
        assertEquals(0, maxSubArray(values));

        values = List.of(0, 0, 0, 1);
        assertEquals(2, maxSubArraySlow(values));
        assertEquals(2, maxSubArray(values));

        values = List.of(0, 0, 1, 0);
        assertEquals(2, maxSubArraySlow(values));
        assertEquals(2, maxSubArray(values));

        values = List.of(1, 0, 0, 0);
        assertEquals(2, maxSubArraySlow(values));
        assertEquals(2, maxSubArray(values));

        values = List.of(1, 0, 0, 1);
        assertEquals(4, maxSubArraySlow(values));
        assertEquals(4, maxSubArray(values));
    }

    int maxSubArray(List<Integer> values) {
        int sum = 0;
        int max = 0;
        for (int value : values) {
            sum += value == 0 ? -1 : 1;
        }

        return max;
    }

    int maxSubArraySlow(List<Integer> values) {
        int max = 0;
        for (int i = 0; i < values.size(); i++) {
            for (int j = i + 1; j < values.size(); j++) {
                if (hasEqual01(values, i, j)) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    boolean hasEqual01(List<Integer> values, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += values.get(i) == 0 ? -1 : 1;
        }
        return sum == 0;
    }

//    List<List<Integer>> allContiguousSubarrays(List<Integer> values) {
//        List<List<Integer>> result = new ArrayList<>();
//        for (int i = 0; i < values.size(); i++) {
//            List<Integer> sub = new ArrayList<>();
//            sub.add(values.get(i));
//            result.add(new ArrayList<>(sub));
//            for (int j = i + 1; j < values.size(); j++) {
//                sub.add(values.get(j));
//                result.add(new ArrayList<>(sub));
//            }
//        }
//
//        return result;
//    }

}
