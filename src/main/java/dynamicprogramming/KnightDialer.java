package dynamicprogramming;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

// https://medium.com/hackernoon/google-interview-questions-deconstructed-the-knights-dialer-f780d516f029
public class KnightDialer {

    @Test
    public void test() {
        assertEquals(14672384, numberOfDials(1, 20));
        assertEquals(5, numberOfDials(1, 2));
        assertEquals(804528128, memoizedNumberOfDials(1, 25));
        assertEquals(5, memoizedNumberOfDials(1, 2));
    }

    Map<Integer, List<Integer>> moves = new HashMap<>() {{
        put(1, List.of(6, 8));
        put(2, List.of(7, 9));
        put(3, List.of(4, 8));
        put(4, List.of(3, 9, 0));
        put(5, List.of());
        put(6, List.of(1, 7, 0));
        put(7, List.of(2, 6));
        put(8, List.of(1, 3));
        put(9, List.of(2, 4));
        put(0, List.of(4, 6));
    }};

    long numberOfDials(int current, int hops) {

        if (hops == 0) {
            return 1;
        }

        long sum = 0;
        for (int move: moves.get(current)) {
            sum += numberOfDials(move, hops-1);
        }

        return sum;
    }

    long[][] cache = new long[1000][1000];

    long memoizedNumberOfDials(int current, int hops) {
        if (cache[current][hops] != 0) {
            return cache[current][hops];
        }
        if (hops == 0) {
            return 1;
        }

        long sum = 0;
        for (int move: moves.get(current)) {
            sum += memoizedNumberOfDials(move, hops-1);
        }
        cache[current][hops] = sum;
        return sum;
    }

    int dpNumberOfDials(int current, int hops) {

        return 0;
       // TODO
    }
}
