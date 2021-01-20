package codejam;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class AtmQueue {

    /**
     * Problem
     * There are N people numbered from 1 to N, standing in a queue to withdraw money from an ATM. The queue is
     * formed in ascending order of their number. The person numbered i wants to withdraw amount Ai. The maximum
     * amount a person can withdraw at a time is X. If they need more money than X, they need to go stand at the
     * end of the queue and wait for their turn in line. A person leaves the queue once they have withdrawn the
     * required amount.
     * You need to find the order in which all the people leave the queue.
     * <p>
     * Input
     * The first line of the input gives the number of test cases T. T test cases follow.
     * The first line of each test case gives two space separated integers: the number of people standing in the
     * queue, N and the maximum amount X that can be withdrawn in one turn.
     * The next line contains N space separated integers Ai.
     * <p>
     * Output
     * For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1)
     * and y is the space separated list of integers that denote the order in which the people leave the queue.
     */

    @Test
    public void test() {
        String input = "2\n" +
                "3 3\n" +
                "2 7 4\n" +
                "5 6\n" +
                "9 10 4 7 2";
        String expected = "Case #1: 1 3 2\nCase #2: 3 5 1 2 4";

        assertEquals(expected, problem(input));
    }

    public String problem(String args) {
        Scanner in = new Scanner(new BufferedReader(new StringReader(args)));
        long t = in.nextLong();
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int max = in.nextInt();
            int[] values = new int[n];
            for (int val = 0; val < n; val++) {
                values[val] = in.nextInt();
            }
            result.append("Case #").append(i).append(": ").append(queue(n, max, values)).append("\n");
        }
        return result.toString();
    }

    String queueOld(int n, int max, int[] amounts) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < amounts.length; i++) {
            queue.add(i);
        }

        List<Integer> outgoing = new ArrayList<>();
        while (!queue.isEmpty()) {

            int person = queue.poll();
            if (amounts[person] <= max) {
                outgoing.add(person);
            } else {
                amounts[person] -= max;
                queue.add(person);
            }

        }
        StringBuilder result = new StringBuilder();
        for (int person : outgoing) {
            result.append(person + 1).append(" ");
        }
        return result.toString().trim();
        // System.out.println("n="+n+" max="+max+" amounts="+Arrays.toString(amounts));
        // return "n="+n+" max="+max+" amounts="+Arrays.toString(amounts);
    }

    String queue(int n, int max, int[] amounts) {

        List<Integer> queue = new ArrayList<>();
        for (int i = 0; i < amounts.length; i++) {
            queue.add(i);
        }

        queue.sort(Comparator.comparingDouble(num -> amounts[num] / max));

        StringBuilder result = new StringBuilder();
        for (int person : queue) {
            result.append(person + 1).append(" ");
        }
        return result.toString().trim();
        // System.out.println("n="+n+" max="+max+" amounts="+Arrays.toString(amounts));
        // return "n="+n+" max="+max+" amounts="+Arrays.toString(amounts);
    }


}
