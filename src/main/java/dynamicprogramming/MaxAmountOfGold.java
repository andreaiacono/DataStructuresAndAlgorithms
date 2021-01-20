package dynamicprogramming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class MaxAmountOfGold {

    /**
     * Maximum Amount of Gold Problem
     * Given a set of gold bars of various weights and a backpack that can hold at most W pounds,
     * place as much gold as possible into the backpack.
     * <p>
     * Input: A set of n gold bard of integer weights w 1 , . . . , w n and
     * a backpack that can hold at most W pounds
     * <p>
     * Output: A subset of gold bars of maximum total weight not exceeding W
     */

    @Test
    public void test() {
        int[] weights = new int[]{4, 5, 5, 6, 6, 6, 10, 9, 8, 8};
        int capacity = 25;

        List<Integer> expected = List.of(4, 5, 6, 10);
        assertEquals(expected, maxGold(weights, capacity, new ArrayList<>(), 0));
    }

    private List<Integer> maxGold(int[] weights, int capacity, List<Integer> tmp, int index) {
        if (capacity == 0) {
            return new ArrayList<>(tmp);
        }

        List<Integer> result = null;
        for (int i = index; i < weights.length; i++) {
            int currentWeight = weights[i];
            if (currentWeight <= capacity) {
                tmp.add(currentWeight);
                result = maxGold(weights, capacity - currentWeight, tmp, i + 1);
                if (result != null) {
                    return result;
                }
                tmp.remove(tmp.size() - 1);
            }
        }
        return result;
    }
}
