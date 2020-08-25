package misc;

import java.util.ArrayList;
import java.util.List;

public class FixedSizeSubset {

    public static void main(String[] args) {

        int[] set = new int[]{1, 2, 3, 4};
        int size = 2;

        List<List<Integer>> result = subsets(0, new ArrayList<>(), set, size);
        System.out.println(result);
    }

    private static List<List<Integer>> subsets(int current, List<Integer> currentSubset, int[] set, int size) {

        if (currentSubset.size() == size) {
            List<List<Integer>> partialResult =  new ArrayList<>();
            partialResult.add(new ArrayList<>(currentSubset));
            return partialResult;
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = current; i < set.length; i++) {
            currentSubset.add(set[i]);
            result.addAll(subsets(i + 1, currentSubset, set, size));
            currentSubset.remove(Integer.valueOf(set[i]));
        }
        return result;
    }
}
