package topcoder;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class ZigZag {

    @Test
    public void test() {
        assertEquals(6, longestZigZag(new int[]{1, 7, 4, 9, 2, 5}));
        assertEquals(7, longestZigZag(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
        assertEquals(1, longestZigZag(new int[]{44}));
        assertEquals(2, longestZigZag(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        assertEquals(8, longestZigZag(new int[]{70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32}));
        assertEquals(36, longestZigZag(new int[]{374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 249, 22, 176, 279, 23, 22, 617, 462, 459, 244}));
        assertEquals(26, longestZigZag(new int[]	{89, 106, 125, 142, 141, 137, 158, 184, 191, 189, 189, 206, 228, 240, 228, 263, 259, 256, 266, 287, 302, 297, 330, 341, 353, 353, 364, 376, 365, 398, 386, 420, 413, 419, 451, 441, 463, 484, 480, 487, 494, 520, 534, 542, 534, 541, 571, 584, 565, 577}));
    }

    class Result {
        int length;
        int lastOp; // [-1,0,1] if last difference was negative, was the first element, was positive

        public Result(int length, int lastOp) {
            this.length = length;
            this.lastOp = lastOp;
        }

        @Override
        public String toString() {
            return length + ", " + lastOp;
        }
    }

    int longestZigZag(int[] sequence) {
        Result[] results = new Result[sequence.length+1];
        Arrays.fill(results, new Result(1, 0));
        for (int j=1; j<sequence.length; j++) {
            for (int i=0; i<j; i++) {
                if ((results[i].lastOp == 0)
                        || ( results[i].lastOp == -1 && sequence[j] - sequence[i] > 0)
                        || ( results[i].lastOp == 1  && sequence[j] - sequence[i] < 0) ) {
                    if (results[i].length + 1 > results[j].length) {
                        results[j] = new Result(results[i].length + 1, (sequence[j] - sequence[i] < 0) ? -1 : 1);
                    }
                }
            }
        }
        return Arrays.stream(results).max(Comparator.comparingInt(r -> r.length)).get().length;
    }
}
