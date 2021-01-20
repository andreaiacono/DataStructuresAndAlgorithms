package recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TwoPartitions {

    @Test
    public void test() {
        List<Integer> values = List.of(11, 3, 3, 4, 5, 6, 8, 25, 2, 10, 7);
        List<List<Integer>> result = twoPartitions(values);
        System.out.println(result);
        assertEquals(List.of(25, 10, 7), result.get(0));
        assertEquals(List.of(11, 3, 3, 4, 5, 6, 8, 2), result.get(1));

        List<Pair> all = twoPartitionsAll(values, 0, new Pair(new ArrayList<>(), new ArrayList<>()));
        System.out.println(all);
        assertEquals(40, all.size());
    }


    List<Pair> twoPartitionsAll(List<Integer> values, int index, Pair tmp) {

        if (tmp.first.size() + tmp.second.size() == values.size()) {
            if (sum(tmp.first) == sum(tmp.second)) {
                return List.of(new Pair(new ArrayList<>(tmp.first), new ArrayList<>(tmp.second)));
            }
        }

        List<Pair> result = new ArrayList<>();
        for (int i = index; i < values.size(); i++) {
            tmp.first.add(values.get(i));
            List<Pair> subResult = twoPartitionsAll(values, i + 1, tmp);
            if (subResult != null) {
                result.addAll(subResult);
            }
            tmp.first.remove(tmp.first.size() - 1);

            tmp.second.add(values.get(i));
            subResult = twoPartitionsAll(values, i + 1, tmp);
            if (subResult != null) {
                result.addAll(subResult);
            }

            tmp.second.remove(tmp.second.size() - 1);
        }
        return result;
    }

    class Pair {
        List<Integer> first;
        List<Integer> second;

        public Pair(List<Integer> first, List<Integer> second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "{" + first + "," + second + "}";
        }
    }

    int sum(List<Integer> values) {
        return values.stream().mapToInt(n -> n).sum();
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


