package searching;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class LongestIncreasingSubsequence {

    static int dp(List<Integer> values) {
        int[] results = new int[values.size()+1];
        Arrays.fill(results, 1);
        for (int i=1; i<values.size(); i++) {
            for (int j=0; j<i; j++) {
                if (values.get(j) <= values.get(i)) {
                    if (results[j] +1 > results[i]) {
                        results[i] = results[j] + 1;
                    }
                }
            }
        }
        return Arrays.stream(results).max().getAsInt();
    }

    private static boolean isIncreasing(List<Integer> values) {
        if (values.size() < 2) {
            return true;
        }
        for (int j = 1; j < values.size(); j++) {
            if (values.get(j - 1) > values.get(j)) {
                return false;
            }
        }
        return true;
    }

    static Map<List<Integer>, Integer> cache = new HashMap<>();

    public static int patienceSort(List<Integer> values, List<Deque<Integer>> piles) {
        for (Integer value: values) {
            Deque<Integer> pile = getGreaterPile(value, piles);
            if (pile != null) {
                pile.push(value);
            }
            else {
                Deque<Integer> stack = new ArrayDeque<>();
                stack.push(value);
                piles.add(stack);
            }
        }

        return piles.size();
    }

    private static Deque<Integer> getGreaterPile(Integer value, List<Deque<Integer>> piles) {
        for (Deque<Integer> stack: piles) {
            if (stack.peek() > value) {
                return stack;
            }
        }
        return null;
    }


    public static int getLongestSubsequence(List<Integer> values) {

        if (cache.containsKey(values)) {
            return cache.get(values);
        }

        if (isIncreasing(values)) {
            return values.size();
        }


        int max = 0;
        for (int j = 0; j < values.size(); j++) {
            int removed = values.remove(j);
            int longest = getLongestSubsequence(values);
            if (max < longest) {
                max = longest;
            }
            values.add(j, removed);
        }

        cache.put(values, max);
        return max;
    }

    @Test
    public void test() {

        List<Integer> values = new LinkedList<>(Arrays.asList(1, 2, 3));
        assertTrue(isIncreasing(values));

        values = Arrays.asList(1, 2, 1);
        assertFalse(isIncreasing(values));

        values = Arrays.asList(1);
        assertTrue(isIncreasing(values));

        values = new LinkedList<>();
        assertTrue(isIncreasing(values));

        values = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(5, getLongestSubsequence(values));
        assertEquals(5, patienceSort(values, new LinkedList<>()));
        assertEquals(5, dp(values));

        values = new LinkedList<>(Arrays.asList(1, 2, 3, 2, 5));
        assertEquals(4, getLongestSubsequence(values));
        assertEquals(4, patienceSort(values, new LinkedList<>()));
        assertEquals(4, dp(values));

        values = new LinkedList<>(Arrays.asList(5, 1, 3, 7, 4, 6, 5, 4, 8, 9, 6, 5, 3, 2, 1));
        assertEquals(6, getLongestSubsequence(values));
        assertEquals(6, patienceSort(values, new LinkedList<>()));
        assertEquals(6, dp(values));

        values = new LinkedList<>(Arrays.asList(15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1));
        assertEquals(1, getLongestSubsequence(values));
        assertEquals(1, patienceSort(values, new LinkedList<>()));
        assertEquals(1, dp(values));
    }
}
