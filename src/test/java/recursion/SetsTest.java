package recursion;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SetsTest {

    @Test
    public void allSubsets() throws Exception {
        Set<Integer> set0 = new HashSet<>();
        set0.add(2);
        set0.add(1);
        assertEquals(4, Sets.allSubsets(set0).size());

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(9);
        set.add(10);
        set.add(11);
        set.add(12);
        assertEquals(4096, Sets.allSubsets(set).size());
    }


    @Test
    public void pairs() {
        Integer[] n = new Integer[]{1, 2, 3, 4, 5};
        Set<Sets.Pair> pairs = Sets.getPairs(n, 0);
        System.out.println("pairs=" + pairs);
        assertEquals(10, pairs.size());
        assertTrue(pairs.contains(new Sets.Pair(1, 2)));
        assertTrue(pairs.contains(new Sets.Pair(1, 3)));
        assertTrue(pairs.contains(new Sets.Pair(1, 4)));
        assertTrue(pairs.contains(new Sets.Pair(1, 5)));
        assertTrue(pairs.contains(new Sets.Pair(2, 3)));
        assertTrue(pairs.contains(new Sets.Pair(2, 4)));
        assertTrue(pairs.contains(new Sets.Pair(2, 5)));
        assertTrue(pairs.contains(new Sets.Pair(3, 4)));
        assertTrue(pairs.contains(new Sets.Pair(3, 5)));
        assertTrue(pairs.contains(new Sets.Pair(4, 5)));

    }

    @Test
    public void triples() {
        Integer[] n = new Integer[]{1, 2, 3, 4, 5};
        Set<Sets.Triple> triples = Sets.getTriples(n, 0);
        System.out.println("triples=" + triples);
        assertEquals(10, triples.size());
        assertTrue(triples.contains(new Sets.Triple(1, 2, 3)));
        assertTrue(triples.contains(new Sets.Triple(1, 2, 4)));
        assertTrue(triples.contains(new Sets.Triple(1, 2, 5)));
        assertTrue(triples.contains(new Sets.Triple(1, 3, 4)));
        assertTrue(triples.contains(new Sets.Triple(1, 3, 5)));
        assertTrue(triples.contains(new Sets.Triple(1, 4, 5)));
        assertTrue(triples.contains(new Sets.Triple(2, 3, 4)));
        assertTrue(triples.contains(new Sets.Triple(2, 3, 5)));
        assertTrue(triples.contains(new Sets.Triple(2, 4, 5)));
        assertTrue(triples.contains(new Sets.Triple(3, 4, 5)));

    }


    @Test
    public void nChooseK() {
        Integer[] n = new Integer[]{1, 2, 3, 4, 5};
        Set<List<Integer>> binomial = Sets.nChooseK(n, 2);
        System.out.println(binomial);
        assertEquals(10, binomial.size());
        assertTrue(binomial.contains(Arrays.asList(new Integer[]{1, 2})));
        assertTrue(binomial.contains(Arrays.asList(new Integer[]{1, 3})));
        assertTrue(binomial.contains(Arrays.asList(new Integer[]{1, 4})));
        assertTrue(binomial.contains(Arrays.asList(new Integer[]{1, 5})));
        assertTrue(binomial.contains(Arrays.asList(new Integer[]{2, 3})));
        assertTrue(binomial.contains(Arrays.asList(new Integer[]{2, 4})));
        assertTrue(binomial.contains(Arrays.asList(new Integer[]{2, 5})));
        assertTrue(binomial.contains(Arrays.asList(new Integer[]{3, 4})));
        assertTrue(binomial.contains(Arrays.asList(new Integer[]{3, 5})));
        assertTrue(binomial.contains(Arrays.asList(new Integer[]{4, 5})));

        n = new Integer[]{1};
        binomial = Sets.nChooseK(n, 2);
        System.out.println(binomial);
        assertEquals(0, binomial.size());

        n = new Integer[]{1, 2};
        binomial = Sets.nChooseK(n, 2);
        System.out.println(binomial);
        assertEquals(1, binomial.size());
    }

    @Test
    public void subsetSum() {
        int a[] = new int[]{3, 34, 4, 12, 5, 2};
        assertTrue(Sets.subsetSum(a, 9));
    }

    @Test
    public void parenthesis() {
        Sets.parenthesisGenerator(5);
    }

    @Test
    public void coinChange() {
        int[] values = {25, 10, 5, 1};
//        assertEquals(2, Sets.coinChange(values, 5));
        assertEquals(4, Sets.coinChange(values, 10));
    }
}