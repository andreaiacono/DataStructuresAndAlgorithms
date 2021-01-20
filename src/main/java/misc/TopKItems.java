package misc;

import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertTrue;

public class TopKItems {

    /**
     * Given a non-empty array of integers, return the k most frequent elements.
     *
     * Example 1:
     *
     * Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     *
     * Example 2:
     *
     * Input: nums = [1], k = 1
     * Output: [1]
     */

    @Test
    public void test() {
        int[] arr = new int[] {1,1,1,2,2,3};
        assertTrue(Arrays.equals(new int[] {1, 2}, topKFrequent(arr, 2)));

        arr = new int[] {1};
        assertTrue(Arrays.equals(new int[] {1}, topKFrequent(arr, 1)));
    }

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> counts = new HashMap<>();
        for (int n: nums) {
            int value = 1;
            if (counts.containsKey(n)) {
                value = counts.get(n) + 1;
            }
            counts.put(n, value);
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int n: counts.keySet()) {
            maxHeap.add(new Pair(n, counts.get(n)));
        }

        int[] result = new int[k];
        for (int i=0; i<k; i++) {
            result[i] = maxHeap.poll().key;
        }

        return result;
    }

    class Pair implements Comparable<Pair> {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.value, o.value);
        }
    }
}
