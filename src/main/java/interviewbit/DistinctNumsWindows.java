package interviewbit;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * https://www.interviewbit.com/problems/distinct-numbers-in-window/
 */
public class DistinctNumsWindows {

    @Test
    public void test() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1,2,1,3,4,3));
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2,3,3,2));

        assertEquals(expected, dNums(input, 3));

    }


    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {

        if (B > A.size()) {
            return new ArrayList<>();
        }

        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int i=0; i<A.size(); i++) {
            int n = A.get(i);
            int val = 1;
            if (counts.containsKey(n)) {
                val += counts.get(n);
            }
            counts.put(n, val);
            queue.add(n);

            if (i >= B-1) {
                result.add(counts.keySet().size());
                int peekVal = counts.get(queue.peek());
                if (peekVal == 1) {
                    counts.remove(queue.peek());
                }
                else {
                    counts.put(queue.peek(), peekVal-1);
                }
                queue.poll();
            }
        }
        return result;
    }
/*
    public ArrayList<Integer> dNumsInefficient(ArrayList<Integer> A, int B) {

        if (B > A.size()) {
            return new ArrayList<>();
        }

        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i=0; i<A.size(); i++) {
            queue.add(A.get(i));
            if (i >= B-1) {
                result.add(countDistinct(queue));
                queue.poll();
            }
        }
        return result;
    }
/*
    int countDistinct(Deque<Integer> queue) {
        Set<Integer> items = new HashSet<>();
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            items.add(iterator.next());
        }

        return items.size();
    }
*/
/*
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {

        if (B > A.size()) {
            return new ArrayList<>();
        }

        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2) -> -Integer.compare(n1,n2));
        for (int i=0; i<A.size(); i++) {

            heap.add(A.get(i));
            if (i >= B-1) {
                result.add(heap.peek());
                heap.remove(A.get(i-B+1));
            }
        }

        return result;
    }

*/
}
