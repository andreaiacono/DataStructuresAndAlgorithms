package misc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Random {

    @Test
    public void test() {
        List<Integer> first = new ArrayList<>();
        PseudoRandom rand1 = new PseudoRandom(17);
        IntStream.range(0, 50).forEach(n -> first.add(rand1.next()));

        List<Integer> second = new ArrayList<>();
        PseudoRandom rand2 = new PseudoRandom(17);
        IntStream.range(0, 50).forEach(n -> second.add(rand2.next()));
        assertEquals(first, second);


        first.clear();
        PseudoRandom rand3 = new PseudoRandom();
        IntStream.range(0, 500).forEach(n -> first.add(rand3.next()));

        second.clear();
        PseudoRandom rand4 = new PseudoRandom();
        IntStream.range(0, 500).forEach(n -> second.add(rand4.next()));

        assertNotEquals(first, second);
    }

    static class PseudoRandom {
        long seed;

        public PseudoRandom() {
            seed = Math.abs(System.nanoTime());
        }

        public PseudoRandom(int seed) {
            this.seed = seed;
        }

        /**
         * returns a random number between 1 and 10 (both included)
         */
        public int next() {
            seed = (int) (7 * seed) % 1005073;
            return (int) seed % 10 + 1;
        }

    }
}
