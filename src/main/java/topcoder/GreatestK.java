package topcoder;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static org.junit.Assert.assertTrue;

public class GreatestK {

    @Test
    public void test() {
        assertTrue(Arrays.equals(new int[]{1, 2}, topK(new int[]{1, 2, 3, 1, 2}, 2)));
        assertTrue(Arrays.equals(new int[]{2}, topK(new int[]{1, 2, 3, 1, 2, 2}, 1)));
        assertTrue(Arrays.equals(new int[]{2, 3}, topK(new int[]{2, 1, 0, 3, -1, 3, 2}, 2)));
    }

    class Item {
        int value;
        int occurrences;

        public Item(int value, int occurrences) {
            this.value = value;
            this.occurrences = occurrences;
        }

        public String toString() { return value + "[" + occurrences + "]"; }
    }

    public int[] topK(int[] a, int k) {

        Map<Integer, Integer> counts = new HashMap<>();
        for (int j = 0; j < a.length; j++) {
            if (counts.containsKey(a[j])) {
                counts.put(a[j], counts.get(a[j]) + 1);
            }
            else {
                counts.put(a[j], 1);
            }
        }

        PriorityQueue<Item> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(i1.occurrences, i2.occurrences));
        int counter = 0;
        for (Integer i : counts.keySet()) {
            Item item = new Item(i, counts.get(i));
            if (counter < k) {
                pq.offer(item);
            }
            else if (pq.peek().occurrences < item.occurrences) {
                pq.poll();
                pq.offer(item);
            }
            counter++;
        }

        int[] result = new int[k];
        for (int j = 0; j < k; j++) {
            result[j] = pq.poll().value;
        }

        return result;
    }

    private static void swap(final int input[], final int i, final int j) {
        final int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    private static int partition(final int[] A, final int p, final int r) {
        final double pivot = A[r];
        int i = p - 1;
        int j = p;

        for (j = p; j < r; j++) {
            if (A[j] <= pivot) {
                swap(A, ++i, j);
            }
        }

        swap(A, i + 1, r);
        return i + 1;
    }

    private static int RandomizedPartition(final int[] A, final int p, final int r) {
        final int i = (int) Math.round(p + Math.random() * (r - p));
        swap(A, i, r);
        return partition(A, p, r);
    }


    public static int kthSmallest(final int[] A, final int p, final int r, final int k) {
        if (p < r) {
            final int q = RandomizedPartition(A, p, r);

            final int n = q - p + 1;
            if (k == n) {
                return A[q];
            } else if (k < n) {
                return kthSmallest(A, p, q - 1, k);
            } else {
                return kthSmallest(A, q + 1, r, k - n);
            }
        } else {
            return Integer.MIN_VALUE;
        }
    }


//    public int[] quickSelect(int[] a, int k) {
//
//        final Map<String, Integer> frequencyMap = new HashMap<String, Integer>();
//
//        final String[] words = stream.toLowerCase().trim().split(" ");
//        for (final String word : words) {
//            int freq = 1;
//            if (frequencyMap.containsKey(word)) {
//                freq = frequencyMap.get(word) + 1;
//            }
//
//            // update the frequency map
//            frequencyMap.put(word, freq);
//        }
//
//        // Find kth largest frequency which is same as (n-k)th smallest frequency
//        final int[] frequencies = new int[frequencyMap.size()];
//        int i = 0;
//        for (final int value : frequencyMap.values()) {
//            frequencies[i++] = value;
//        }
//        final int kthLargestFreq = kthSmallest(frequencies, 0, i - 1, i - k);
//
//        // extract the top K
//        final String[] topK = new String[k];
//        i = 0;
//        for (final java.util.Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
//            if (entry.getValue().intValue() >= kthLargestFreq) {
//                topK[i++] = entry.getKey();
//                if (i == k) {
//                    break;
//                }
//            }
//        }
//
//        return topK;
//    }

}
