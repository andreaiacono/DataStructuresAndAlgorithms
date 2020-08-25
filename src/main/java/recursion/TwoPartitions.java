package recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TwoPartitions {

    @Test
    public void test() {
        List<Integer> values = List.of(1, 2, 3, 4, 5, 6, 8, 15, 2, 10, 7);
        System.out.println(twoPartitions(values));
    }

    List<List<Integer>> twoPartitions(List<Integer> values) {
        List<List<Integer>> partial = new ArrayList<>();
        partial.add(new ArrayList<>());
        partial.add(new ArrayList<>());
        return twoPartitions(values, 0, partial);
    }

    List<List<Integer>> twoPartitions(List<Integer> values, int index, List<List<Integer>> partial) {
        if (partial.get(0).size() + partial.get(1).size() == values.size()) {
            return copy(partial);
        }

        partial.get(0).add(values.get(index));
        List<List<Integer>> first = copy(twoPartitions(values, index + 1, partial));
        partial.get(0).remove(partial.get(0).size() - 1);

        partial.get(1).add(values.get(index));
        List<List<Integer>> second = copy(twoPartitions(values, index + 1, partial));
        partial.get(1).remove(partial.get(1).size() - 1);

        return smallestDiff(first, second);
    }

    List<List<Integer>> copy(List<List<Integer>> values) {
        return new ArrayList<>() {{
            add(new ArrayList<>(values.get(0)));
            add(new ArrayList<>(values.get(1)));
        }};
    }

    List<List<Integer>> smallestDiff(List<List<Integer>> l1, List<List<Integer>> l2) {
        long l1_diff = Math.abs(l1.get(0).stream().mapToInt(n -> n).sum() - l1.get(1).stream().mapToInt(n -> n).sum());
        long l2_diff = Math.abs(l2.get(0).stream().mapToInt(n -> n).sum() - l2.get(1).stream().mapToInt(n -> n).sum());
        return l1_diff < l2_diff ? l1 : l2;
    }
}


