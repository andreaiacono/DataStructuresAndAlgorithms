package codejam;

import com.google.common.base.Objects;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class MetalHarvest {

    /**
     *Problem
     *
     * You are in charge of deploying robots to harvest Kickium from a nearby asteroid. Robots are not designed to
     * work as a team, so only one robot can harvest at any point of time. A single robot can be deployed for up to
     * K units of time in a row before it returns for calibration, regardless of how much time it spends on
     * harvesting during that period. Harvesting can only be done during specific time intervals. These time
     * intervals do not overlap. Given K and the time intervals in which harvesting is allowed, what is the minimum
     * number of robot deployments required to harvest at all possible times?
     */

    @Test
    public void test() {
        String input = "2\n" +
                "3 5\n" +
                "1 5\n" +
                "10 11\n" +
                "8 9\n" +
                "3 2\n" +
                "3 5\n" +
                "1 2\n" +
                "13 14";
        String expected = "Case #1: 2\nCase #2: 3";

        input = "3\n" +
                "3 3\n" +
                "1 5\n" +
                "10 11\n" +
                "8 9\n" +
                "3 10\n" +
                "8 9\n" +
                "1 5\n" +
                "10 11\n" +
                "2 10\n" +
                "1 15\n" +
                "28 30";
        expected = "Case #1: 2\nCase #2: 3";

        assertEquals(expected, problem(input));
    }

    public String problem(String args) {
        Scanner in = new Scanner(new BufferedReader(new StringReader(args)));
        long t = in.nextLong();
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int max = in.nextInt();
            List<Slot> slots = new ArrayList<>();
            for (int val = 0; val < n; val++) {
                slots.add(new Slot(in.nextInt(), in.nextInt()));
            }
            result.append("Case #").append(i).append(": ").append(deploy(max, slots)).append("\n");
        }
        return result.toString();
    }

    // (1,5), (8,9), (10,11) k=3
    // 1-3, 4-6, 8-10, 11-13

    // (1,5), (8,9), (10,11) k=10
    // 1-10, 11-20

    // (1,15), (28,30)  k=10
    // 1-10, 11-20, 28-37
    private String deploy(int max, List<Slot> slots) {
        slots.sort(Comparator.comparingInt( slot -> slot.start ));

        int deployed = 0;
        int deployStart = 0;
        int deployEnd = 0;
        for (Slot slot: slots) {
            if (deployEnd < slot.end) {
                deployStart = deployEnd + 1;
                deployEnd = deployStart + max-1;
                deployed ++;
            }
        }

        return "" + deployed;
    }

    class Slot {
        int start;
        int end;

        public Slot(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "("+start+","+end+")";
        }
    }

}
