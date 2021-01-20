package recursion;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class AddUpToK {

    /**
     * Given a list of integers S and a target number k, write a function that returns a subset of S
     * that adds up to k. If such a subset cannot be made, then return null.
     * Integers can appear more than once in the list. You may assume all numbers in the list are positive.
     *
     * For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.
     */

    @Test
    public void test() {
        List<Integer> values = List.of(12, 1, 61, 5, 9, 2);
        int k = 24;
        Set<Integer> expected = Set.of(12, 9, 2, 1);
        assertEquals(expected, addToK(values, k, 0, new HashSet<>()));
    }

    Set<Integer> addToK(List<Integer> values, int k, int index, Set<Integer> tmp) {
        if (k == 0) {
            return new HashSet<>(tmp);
        }

        for (int i=index; i<values.size(); i++) {
            int current = values.get(i);
            if (k - current >= 0) {
                Set<Integer> result = addToK(values, k - current, i + 1, new HashSet<>(tmp) {{ add(current); }});
                if (result != null) {
                    return result;
                }
            }
        }

        return null;
    }

    Set<Integer> addToKSlow(List<Integer> values, int k) {
        List<Set<Integer>> allSubsets = allSubsets(values, 0, new HashSet<>());
        System.out.println(allSubsets);
        for (Set<Integer> subset: allSubsets) {
            int sum = 0;
            for (int value: subset) {
                sum += value;
            }
            if (sum == k) {
                return subset;
            }
        }
        return null;
    }

    List<Set<Integer>> allSubsets(List<Integer> values, int index, Set<Integer> tmp) {
        if (index == values.size()) {
            return List.of(new HashSet<>(tmp));
        }

        return new ArrayList<>() {{
            addAll(allSubsets(values, index + 1, tmp));
            addAll(allSubsets(values, index + 1, new HashSet<Integer>(tmp) {{ add(values.get(index)); }} ));
        }};
    }
}
