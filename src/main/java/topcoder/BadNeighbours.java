package topcoder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BadNeighbours {

    @Test
    public void test() {
        assertEquals(19, maxDonations(new int[]{10, 3, 2, 5, 7, 8}));
//        assertEquals(15, maxDonations(new int[]{11, 15}));
        assertEquals(21, maxDonations(new int[]{7, 7, 7, 7, 7, 7, 7}));
        assertEquals(16, maxDonations(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5}));
        assertEquals(4866, maxDonations(new int[]{347, 49, 608, 460, 67, 856, 21, 526, 552, 412, 761, 286, 481, 441, 598, 933, 462, 328, 92}));
        assertEquals(2610, maxDonations(new int[]{374, 429, 448, 480, 751, 781, 295, 920, 442}));
        assertEquals(3327, maxDonations(new int[]{35, 991, 80, 273, 637, 811, 974, 845, 725}));
        assertEquals(2926, maxDonations(new int[]{94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61, 6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397, 52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72}));
        assertEquals(12773, maxDonations(new int[]{965, 850, 698, 178, 936, 112, 944, 46, 288, 741, 23, 903, 454, 448, 539, 578, 469, 579, 32, 703, 424, 61, 488, 178, 902, 797, 933, 55, 380, 209, 791, 226, 739, 474, 431, 388, 614, 745}));
    }

    class Result {
        int index;
        int value;
        List<Result> neighbours = new ArrayList<>();

        public Result(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public Result(int index, int value, Result precedingResult) {
            this.value = value;
            this.index = index;
            this.neighbours.addAll(precedingResult.neighbours);
            this.neighbours.add(precedingResult);

        }

        public String toString() { return index + "[" + value + "]"; };//+ " " + neighbours; }
    }

    public static int maxDonations(int[] donations)
    {
        int total = donations.length;
        int dp[] = new int[total];
        int max = -1;
        int i = 0;

        dp[0] = donations[0];
        dp[1] = donations[1];
        dp[2] = donations[2] + donations[0];

        for (i = 3; i < donations.length - 1; i++) {
            dp[i] = donations[i] + Math.max(dp[i - 2], dp[i - 3]);
            max = max > dp[i] ? max : dp[i];
        }

        dp[1] = donations[1];
        dp[2] = donations[2];
        dp[3] = donations[3] + donations[1];

        for (i = 4; i < donations.length; i++) {
            dp[i] = donations[i] + Math.max(dp[i - 2], dp[i - 3]);
            max = max > dp[i] ? max : dp[i];
        }


        return max;
    }

    int maxDonations2(int[] donations) {
        Result[] results = new Result[donations.length];

        for (int j = 0; j < donations.length; j++) {
            results[j] = new Result(j, donations[j]);
            int max = 0;
            int maxIndex = -1;
            for (int i = 0; i < j - 1; i++) {
                if (j == donations.length - 1 && results[i].neighbours.stream().anyMatch(r -> r.index == 0)) {
                    continue;
                }
                if (results[i].value > max) {
                    max = results[i].value;
                    maxIndex = i;
                }
            }
            if (maxIndex >= 0) {
                results[j] = new Result(j, max + donations[j], results[maxIndex]);
            }
        }
        System.out.println("Donations=" + Arrays.toString(donations));
        System.out.println("Results=" + Arrays.toString(results));
        System.out.println("elemnats: " + Arrays.stream(results).max((r1, r2) -> Integer.compare(r1.value, r2.value)).get().neighbours);
        return Arrays.stream(results).max((r1, r2) -> Integer.compare(r1.value, r2.value)).get().value;
    }


}
