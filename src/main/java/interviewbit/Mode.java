package interviewbit;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * https://www.interviewbit.com/problems/get-mode-array-updates  (/?test_id=2704)
 */
public class Mode {

    @Test
    public void test() {
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(3, 2, 3));
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(2, 2, 2, 3, 3));
        ArrayList<ArrayList<Integer>> updates = new ArrayList<>();
        updates.add(new ArrayList<>(Arrays.asList(1, 3)));
        updates.add(new ArrayList<>(Arrays.asList(5, 4)));
        updates.add(new ArrayList<>(Arrays.asList(2, 4)));
//        assertEquals(result, getMode(input, updates));

        result = new ArrayList<>(Arrays.asList(2, 2, 2, 1, 2));
        input = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2));
        updates = new ArrayList<>();
        updates.add(new ArrayList<>(Arrays.asList(4, 1)));
        updates.add(new ArrayList<>(Arrays.asList(3, 1)));
        updates.add(new ArrayList<>(Arrays.asList(3, 1)));
        updates.add(new ArrayList<>(Arrays.asList(2, 1)));
        updates.add(new ArrayList<>(Arrays.asList(4, 2)));
        assertEquals(result, getMode(input, updates));

        result = new ArrayList<>(Arrays.asList(1, 3, 3, 3, 3 ));
        input = new ArrayList<>(Arrays.asList(3, 2, 1, 1, 3 ));
        updates = new ArrayList<>();
        updates.add(new ArrayList<>(Arrays.asList(2, 2)));
        updates.add(new ArrayList<>(Arrays.asList(3, 3)));
        updates.add(new ArrayList<>(Arrays.asList(3, 3)));
        updates.add(new ArrayList<>(Arrays.asList(2, 1)));
        updates.add(new ArrayList<>(Arrays.asList(4, 3)));
        assertEquals(result, getMode(input, updates));
    }

    class Item {
        int val;
        int counts;

        public Item(int val, int counts) {
            this.val = val;
            this.counts = counts;
        }

        public boolean equals(Object o) {
            return val == ((Item) o).val;
        }

        public int hashCode() {
            return 31 * val + counts;
        }

        @Override
        public String toString() {
            return "'" + val + "': " + counts ;
        }
    }


    public ArrayList<Integer> getMode(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> b) {
        PriorityQueue<Item> pq = new PriorityQueue<>((i1, i2) -> {
            if (i1.counts == i2.counts) {
                return i1.val < i2.val ? -1 : 1;
            }
            return -Integer.compare(i1.counts, i2.counts);
        });
        Map<Integer, Integer> counts = new HashMap<>();
         ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            int value = 0;
            int item = a.get(i);
            if (counts.containsKey(item)) {
                value = counts.get(item);
            }
            counts.put(item, value + 1);
        }
        for (int key : counts.keySet()) {
            Item item = new Item(key, counts.get(key));
            pq.add(item);
        }

        for (int i = 0; i < b.size(); i++) {

            int position = b.get(i).get(0) - 1;
            int newValue = b.get(i).get(1);

            if (a.get(position) == newValue) {

                if (result.size() == 0) {
                    result.add(getMode(counts));
                }
                else {
                    result.add(result.get(result.size()-1));
                }
                continue;
            }

            if (!counts.containsKey(newValue)) {
                counts.put(newValue, 0);
            }
            pq.remove(new Item(newValue, counts.get(newValue)));
            int newUpdatedCounts = counts.get(newValue) + 1;
            counts.put(newValue, newUpdatedCounts);

            int oldValue = a.get(position);
            pq.remove(new Item(oldValue, counts.get(oldValue)));
            int oldUpdatedCounts = counts.get(oldValue) - 1;
            counts.put(oldValue, oldUpdatedCounts);

            pq.add(new Item(oldValue, oldUpdatedCounts));
            pq.add(new Item(newValue, newUpdatedCounts));
            a.set(position, newValue);

            result.add(pq.peek().val);
        }

        return result;
    }

    private int getMode(Map<Integer, Integer> counts) {
        int max = 0;
        int oldMax = 0;
        int result = Integer.MAX_VALUE;
        for (int key: counts.keySet()) {
            max = Math.max(counts.get(key), max);
            if (counts.get(key) == max && (max > oldMax || result > key)) {
                result = key;
            }
            oldMax = max;
        }
        return result;
    }
}
