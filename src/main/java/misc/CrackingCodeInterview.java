package misc;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CrackingCodeInterview {

    /**
     * problem 3.6
     *
     * @param stack
     */
    public static void sortStack(Deque<Integer> stack) {

        if (stack.isEmpty()) {
            return;
        }

        Deque<Integer> tmpStack = new ArrayDeque<>();
        boolean isSorted = false;
        while (!isSorted) {
            int currentTop = stack.pop();
            while (!stack.isEmpty() && currentTop > stack.peek()) {
                tmpStack.push(currentTop);
                currentTop = stack.pop();
            }
            if (!stack.isEmpty()) {
                tmpStack.push(currentTop);
                currentTop = stack.pop();
            }
            isSorted = stack.isEmpty();
            while (!tmpStack.isEmpty() || currentTop != Integer.MAX_VALUE) {
                if (!tmpStack.isEmpty() && currentTop >= tmpStack.peek()) {
                    stack.push(tmpStack.pop());
                }
                else {
                    stack.push(currentTop);
                    currentTop = Integer.MAX_VALUE;
                }
            }
        }
    }

    /**
     * problem 9.1
     *
     * @return
     */
    public static long runningUpStairs(int steps) {
        long[] results = new long[100];
        for (int j = 0; j < 100; j++) results[j] = -1;
        return count(steps, 0, results);
    }

    private static long count(long steps, long partialSteps, long[] results) {
        if (results[(int) partialSteps] > -1) {
            return results[(int) partialSteps];
        }

        if (steps == partialSteps) {
            return 1;
        }
        if (steps < partialSteps) {
            return 0;
        }

        long counter = count(steps, partialSteps + 1, results);
        counter += count(steps, partialSteps + 2, results);
        counter += count(steps, partialSteps + 3, results);

        results[(int) partialSteps] = counter;
        return counter;
    }

    public static long robotPaths(int gx, int gy) {
        long[][] cache = new long[100][100];
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < 100; i++) {
                cache[i][j] = -1;
            }
        }
        return countPaths(0, 0, gx, gy, cache);
    }

    private static long countPaths(int x, int y, int gx, int gy, long[][] cache) {
        if (x == gx && y == gy) {
            return 1;
        }
        if (x < 0 || x > gx || y < 0 || y > gy) {
            return 0;
        }

        if (cache[x][y] < 0) {
            int counter = 0;
            counter += countPaths(x + 1, y, gx, gy, cache);
            counter += countPaths(x, y + 1, gx, gy, cache);
            cache[x][y] = counter;
        }

        return cache[x][y];
    }

    /**
     * problem 1.5
     */
    boolean isEditDistanceOne(String from, String to) {

        if (Math.abs(from.length() - to.length()) > 1) {
            return false;
        }

        // check for replace
        if (from.length() == to.length()) {
            boolean isDifferent = false;
            for (int i=0; i<from.length(); i++) {
                if (from.charAt(i) != to.charAt(i)) {
                    if (isDifferent) {
                        return false;
                    }
                    isDifferent = true;
                }
            }
            return true;
        }

        return from.length() < to.length()
                ? checkDiffCharacter(from, to) : checkDiffCharacter(to, from);
    }

    private boolean checkDiffCharacter(String from, String to) {
        boolean hasBeenInserted = false;
        for (int fromIndex=0, toIndex=0; fromIndex<from.length(); fromIndex++, toIndex++) {
            if (from.charAt(fromIndex) != to.charAt(toIndex)) {
                if (hasBeenInserted) {
                    return false;
                }
                hasBeenInserted = true;
                toIndex++;
            }
        }
        return true;
    }

    @Test
    public void test() {
        assertTrue(isEditDistanceOne("bake", "bale"));
        assertTrue(isEditDistanceOne("bar", "bart"));
        assertTrue(isEditDistanceOne("bar", "sbar"));
        assertTrue(isEditDistanceOne("bar", "balr"));
        assertTrue(isEditDistanceOne("sbar", "bar"));
        assertTrue(isEditDistanceOne("sbar", "sba"));
        assertTrue(isEditDistanceOne("sbar", "sbr"));
        assertFalse(isEditDistanceOne("sbar", "psar"));
        assertFalse(isEditDistanceOne("sbar", "sbit"));
    }

}
