package recursion;

import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class TugOfWar {

    @Test
    public void test() {
        int n[] = new int[]{3, 4, 5, -3, 90, 1, 89, 54, 23, 20};
        int res0[] = new int[]{4, 90, 1, 23, 20};
        int res1[] = new int[]{3, 5, -3, 89, 54};

        assertEquals(60, sum(new int[] {10,20,30}));
        assertEquals(60, sum(new int[] {0,30,30}));
        assertEquals(0, sum(new int[] {0}));
        assertEquals(10, sum(new int[] {1,2,3,4}));

        int[][] result = tugOfWar(n);

        System.out.println("n=" + Arrays.toString(n));
        System.out.println("sub0=" + Arrays.toString(result[0]));
        System.out.println("sub1=" + Arrays.toString(result[1]));
        System.out.println("diff=" + Math.abs(sum(result[0])- sum(result[1])));

        assertEquals(new TreeSet<>(Ints.asList(result[1])), new TreeSet<>(Ints.asList(res1)));
        assertEquals(new TreeSet<>(Ints.asList(result[0])), new TreeSet<>(Ints.asList(res0)));
    }

    private int[][] tugOfWar(int[] n) {

        int mid = n.length / 2;
        int[] sub1 = Arrays.copyOfRange(n, 0, mid);
        int[] sub2 = Arrays.copyOfRange(n, mid, n.length);

        Queue<Object> r = Collections.asLifoQueue(new ArrayDeque<>());
        Result result = tugOfWar(sub1, sub2, 0);
        return new int[][]{result.sub1, result.sub2};
    }

    private Result tugOfWar(int[] sub1, int[] sub2, int index) {
        Result result = new Result(Math.abs(sum(sub1) - sum(sub2)), Arrays.copyOf(sub1, sub1.length), Arrays.copyOf(sub2, sub2.length));
        if (result.diff == 0) {
            return result;
        }

        for (int j = index; j < sub1.length; j++) {
            for (int i = index; i < sub2.length; i++) {
                swap(sub1, j, sub2, i);
                Result localResult = tugOfWar(sub1, sub2, index + 1);
                if (localResult.diff == 0) {
                    return localResult;
                }
                if (localResult.diff < result.diff) {
                    result = localResult;
                }
                swap(sub1, j, sub2, i);
            }
        }
        return result;
    }

    private void swap(int[] sub1, int j, int[] sub2, int i) {
        int temp = sub1[j];
        sub1[j] = sub2[i];
        sub2[i] = temp;
    }

    private int sum(int n[]) {
        return Arrays.stream(n).sum();
    }

    class Result {
        int diff;
        int[] sub1;
        int[] sub2;

        public Result(int diff, int[] sub1, int[] sub2) {
            this.diff = diff;
            this.sub1 = sub1;
            this.sub2 = sub2;
        }
    }
}
