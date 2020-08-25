package bit;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;

public class BinaryWatch {

    @Test
    public void test() {
        System.out.println(readBinaryWatch(3));
    }

    public List<String> readBinaryWatch(int num) {
        ArrayList<String> result = new ArrayList<>(readBinaryWatch(0, new ArrayList<>(), num));

        Collections.sort(result, (s1, s2) -> {
            String h1 = s1.split(":")[0];
            String h2 = s2.split(":")[0];
            if (!h1.equals(h2)) {
                return s1.compareTo(s2);
            }
            String m1 = s1.split(":")[1];
            String m2 = s2.split(":")[1];
            return s1.compareTo(s2);
        });

        return result;
    }

    public Set<String> readBinaryWatch(int index, List<Integer> positions, int num) {
//        System.out.println("index="+index+" pos="+positions);
        if (positions.size() == num) {
            return Set.of(time(positions));
        }
        Set<String> result = new HashSet<>();
        for (int i=index; i<= 10; i++) {
            positions.add(i);
            result.addAll(readBinaryWatch(index+1, new ArrayList<>(positions), num));
            positions.remove(positions.size()-1);
        }
        return result;
    }

    String time(List<Integer> positions) {
        List<String> result = new ArrayList<>();

        List<Integer> hourPositions = positions.stream().filter(n -> n<4).collect(Collectors.toList());
        List<Integer> minutePositions = positions.stream().filter(n -> n>3).map(n -> n-4).collect(Collectors.toList());

        return getValue(hourPositions, false) + ":" + getValue(minutePositions, true);
    }

    String getValue(List<Integer> positions, boolean hasLeadingZero) {
        String value;
        int sum = 0;
        for (int pos: positions) {
            int mask = 1;
            mask <<= pos;
            sum += mask;
        }
        value = "" + sum;
        return (hasLeadingZero && sum < 10 ? "0" : "") + value;
    }
}
