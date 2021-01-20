package misc;

import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class FixedSizeSubset {


    @Test
    public void test() {
        int[] set = new int[]{1, 2, 3, 4};
        System.out.println(iterativeSubsets(set, 2));
        int size = 2;
        List<List<Integer>> result = subsets(0, new ArrayList<>(), set, size);
        assertEquals(6, result.size());

//        all_combinations(set, 2);
        result = iterativeSubsets(set, size);
        assertEquals(6, result.size());
        System.out.println(result);
    }

    static List<List<Integer>> subsets(int current, List<Integer> currentSubset, int[] set, int size) {

        if (currentSubset.size() == size) {
            return List.of(new ArrayList<>(currentSubset));
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = current; i < set.length; i++) {
            currentSubset.add(set[i]);
            result.addAll(subsets(i + 1, currentSubset, set, size));
            currentSubset.remove(currentSubset.size() - 1);
        }
        return result;
    }

    List<List<Integer>> iterativeSubsets(int[] set, int k) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < (1 << set.length); i++) {
            List<Integer> tmp = new ArrayList<>();
            int cur = gray_code(i);
            if (count_bits(cur) == k) {
                for (int j = 0; j < set.length; j++) {
                    if ((cur & (1 << j) ) == 0) {
                        tmp.add(j+1);
                    }
                }
                result.add(tmp);
            }
        }
        return result;
    }

    int gray_code (int n) {
        return n ^ (n >> 1);
    }

    int count_bits (int n1) {
        int res = 0;
        for (int n=n1; n > 0;n >>= 1) {
            res += n & 1;
        }
        return res;
    }

}
