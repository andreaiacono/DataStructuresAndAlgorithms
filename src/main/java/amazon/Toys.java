package amazon;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Toys {

    /**
     * Given an array consisting of cost of toys. Given an integer K depicting the amount of money available
     * to purchase toys. Write a program to find the maximum number of toys one can buy with the amount K.
     * Note: One can buy only 1 quantity of a particular toy.
     */

    @Test
    public void test() {
        int k = 50;
        int[] cost = new int[]{1, 12, 5, 111, 200, 1000, 10, 9, 12, 15};
        assertEquals(6, maxToys(cost, k));
        assertEquals(6, maxToys2(cost, k, 0, 0));
        assertEquals(6, maxToysMemo(cost, k, 0, 0, new int[cost.length + 1][k + 1]));
        assertEquals(6, maxToysSort(cost, k));

        k = 50;
        cost = new int[]{1, 12, 5, 111, 200, 1000, 10};
        assertEquals(4, maxToys(cost, k));
        assertEquals(4, maxToys2(cost, k, 0, 0));
        assertEquals(4, maxToysMemo(cost, k, 0, 0, new int[cost.length + 1][k + 1]));
        assertEquals(4, maxToysSort(cost, k));
    }


    private int maxToys2(int[] cost, int k, int index, int toys) {
        if (k == 0) {
            return toys;
        }

        int max = toys;
        for (int i = index; i < cost.length; i++) {
            if (k >= cost[i]) {
                max = Math.max(max, maxToys2(cost, k - cost[i], i + 1, toys + 1));
            }
        }
        return max;
    }

    int maxToysSort(int[] costs, int k) {
        Arrays.sort(costs);
        int sum = 0;
        for (int i = 0; i < costs.length; i++) {
            int cost = costs[i];
            if (sum + cost > k) {
                return i;
            }
            sum += cost;
        }
        return costs.length;
    }


    private int maxToysMemo(int[] cost, int k, int index, int toys, int[][] cache) {
        if (k == 0) {
            return toys;
        }

        if (cache[index][k] > 0) {
            return cache[index][k];
        }

        int max = toys;
        for (int i = index; i < cost.length; i++) {
            if (k >= cost[i]) {
                max = Math.max(max, maxToysMemo(cost, k - cost[i], i + 1, toys + 1, cache));
            }
        }

        cache[index][k] = max;
        return max;
    }


    private int maxToys(int[] cost, int k) {
        List<List<Integer>> subsets = allSubsets(cost, 0, new ArrayList<>());
        int max = 0;
        for (List<Integer> subset : subsets) {
            if (costs(subset) <= k) {
                max = Math.max(max, subset.size());
            }
        }
        return max;
    }

    private int costs(List<Integer> subset) {
        return subset.stream().mapToInt(n -> n).sum();
    }

    private List<List<Integer>> allSubsets(int[] cost, int index, List<Integer> tmp) {
        if (index == cost.length) {
            return List.of(new ArrayList<>(tmp));
        }
        return new ArrayList<>() {{
            addAll(allSubsets(cost, index + 1, tmp));
            addAll(allSubsets(cost, index + 1, new ArrayList<>(tmp) {{
                add(cost[index]);
            }}));
        }};
    }
}
