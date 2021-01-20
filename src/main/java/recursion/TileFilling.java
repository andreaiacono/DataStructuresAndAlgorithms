package recursion;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TileFilling {

    /*
     * You are given a 2 x N board, and instructed to completely cover the board with the following shapes:
     *
     *     Dominoes, or 2 x 1 rectangles.
     *     Trominoes, or L-shapes.
     *
     * For example, if N = 4, here is one possible configuration, where A is a domino, and B and C are trominoes.
     *
     * A B B C
     * A B C C
     * or
     * A B C C
     * A B B C
     * or
     * B B C A
     * B C C A
     * or
     * B C C A
     * B B C A
     * or
     * A A A A
     * A A A A
     * Given an integer N, determine in how many ways this task is possible.
     */

    @Test
    public void test() {
        assertEquals(5, countFillings(4, false));
        assertEquals(1, countFillings(2, false));
        assertEquals(3, countFillings(3, false));
    }

    int countFillings(int size, boolean hasTrominos) {
        if (size == 0) {
            return hasTrominos ? 2 : 1;
        }

        int dominos = countFillings(size - 1, hasTrominos);
        int trominos = 0;
        if (size > 2) {
            trominos = countFillings(size - 3, true);
        }
        return dominos + trominos;
    }

}
