package misc;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

public class TopKthItem {

    @Test
    public void test() {
        int[] items =  new int[]{4, 1, 3, 12, 7, 14};
        assertEquals(14, getTopKthItem(items, 1));
        assertEquals(12, getTopKthItem(items, 2));
        assertEquals(7, getTopKthItem(items, 3));
        assertEquals(4, getTopKthItem(items, 4));
        assertEquals(3, getTopKthItem(items, 5));
        assertEquals(1, getTopKthItem(items, 6));
    }

    int getTopKthItem(int[] items, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(items.length, Comparator.reverseOrder());
        for (int i=0; i<items.length; i++) {
            maxHeap.add(items[i]);
        }

        for (int i=0; i<k-1; i++) {
            maxHeap.poll();
        }

        return maxHeap.poll();
    }
}
