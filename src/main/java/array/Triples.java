package array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

public class Triples {

    /**
     * Given an array of integers where every integer occurs three times except for one integer, which only
     * occurs once, find and return the non-duplicated integer.
     * Do this in O(N) time and O(1) space.
     */

    @Test
    public void test() {
        int[] arr = new int[]{6, 1, 4, 3, 4, 3, 3, 6, 6, 4};
        assertEquals(1, findUnique(arr));
        assertEquals(1, findUniqueQuick(arr));

        arr = new int[]{13, 19, 13, 13};
        assertEquals(19, findUnique(arr));
        assertEquals(19, findUniqueQuick(arr));
    }

    // linear space complexity
    int findUniqueQuick(int[] arr) {

        int ones = 0;
        int twos = 0;
        int not_threes;
        for (int n : arr) {
            twos ^= ones & n;
            ones ^= n;
            not_threes = ~(ones & twos);
            ones &= not_threes;
            twos &= not_threes;
        }
        return ones;
    }

    // linear space complexity
    int findUnique(int[] arr) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int n: arr) {
            int occurrence = 0;
            if (occurrences.containsKey(n)) {
                occurrence = occurrences.get(n);
            }
            occurrences.put(n, occurrence + 1);
        }

        for (int n: occurrences.keySet()) {
            if (occurrences.get(n) == 1) {
                return n;
            }
        }

        return -1;
    }

}
