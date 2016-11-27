package misc;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class PairSums {

    @Test
    public void test() {
        Set<Pair> pairs = new HashSet<Pair>() {{
            add(new Pair(5, 1));
        }};
        assertEquals(pairs, getPairsForSum(new int[]{1, 2, 5, 6}, 6));
        pairs = new HashSet<Pair>() {{
            add(new Pair(3, 2));
        }};
        assertEquals(pairs, getPairsForSum(new int[]{0, 1, 1, 2, 3, 2, 2, 1, 1, 0}, 5));
        pairs = new HashSet<Pair>() {{
            add(new Pair(0, 5));
            add(new Pair(6, -1));
            add(new Pair(1, 4));
            add(new Pair(3, 2));
        }};
        assertEquals(pairs, getPairsForSum(new int[]{ 0, -1, 2, 3, 1, 5, 6, 4, 2}, 5));
        assertEquals(new Pair(1,2), new Pair(2,1));
    }

    private Set<Pair> getPairsForSum(int[] a, int sum) {

        Set<Pair> results = new HashSet<>();
        Set<Integer> partials = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            if (partials.contains(sum - a[i])) {
                Pair result = new Pair(a[i], sum - a[i]);
                results.add(result);
                partials.remove(sum - a[i]);
            }
            else {
                partials.add(a[i]);
            }
        }

        return results;
    }


    class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public boolean equals(Object o) {
            if (o == null || !(o instanceof Pair)) {
                return false;
            }

            Pair other = (Pair) o;
            return (other.a == this.a && other.b == this.b) || (other.a == this.b && other.b == this.a);
        }

        public int hashCode() {
            return a + b;
        }

        public String toString() { return "(" + a + "," + b + ")";}
    }


}
