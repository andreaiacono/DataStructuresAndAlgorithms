package misc;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class MajorityItem {

    /**
     * Write a function which takes an array and prints the majority element (if it exists), otherwise
     * prints “No Majority Element”. A majority element in an array A[] of size n is an element that
     * appears more than n/2 times (and hence there is at most one such element).
     *
     * https://www.geeksforgeeks.org/majority-element/
     */

    @Test
    public void test() {
        int[] items = new int[] {10, 22, 22, 21, 22, 23, 22};
        assertEquals(22, simpleMajority(items));
    }

    int simpleMajority(int[] items) {
        int maxValue = 0;
        int maxOccurrences = 0;
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int n: items) {
            int val = 0;
            if (occurrences.containsKey(n)) {
                val = occurrences.get(n);
                if (maxOccurrences < val) {
                    maxOccurrences = val;
                    maxValue = n;
                }
            }
            occurrences.put(n, val + 1);
        }
        return maxOccurrences >= items.length / 2 ? maxValue : -1;
    }

}
