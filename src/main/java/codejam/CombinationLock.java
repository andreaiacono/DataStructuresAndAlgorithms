package codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class CombinationLock {

    static String input = "2\n" +
            "3 5\n" +
            "2 3 4\n" +
            "4 10\n" +
            "2 9 3 8";

    public static void main(String[] args) {
//      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Scanner in = new Scanner(new BufferedReader(new StringReader(input)));

        long n = in.nextLong(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 0; i < n; i++) {
            int size = in.nextInt();
            int max = in.nextInt();

            int[] values = new int[size];
            for (int j = 0; j < size; j++) {
                values[j] = in.nextInt();
            }
            int result = findMoves(max, values);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    static int findMoves(int max, int[] values) {

        Node start = new Node(values);
        Set<Node> visited = new HashSet<>();
        Deque<Node> toVisit = new ArrayDeque<>();
        toVisit.add(start);

        while (!toVisit.isEmpty()) {
            System.out.println("Visited= " + visited);
            Node current = toVisit.poll();
            if (current.hasEqualValues()) {
                return current.steps;
            }
            visited.add(current);

            for (int i = 0; i < values.length; i++) {
                int oldValue = current.values[i];
                current.values[i] = (current.values[i] + 1) % max;
                Node neighbour = new Node(Arrays.copyOf(values, values.length));
                if (!visited.contains(neighbour)) {
                    neighbour.steps = current.steps + 1;
                    toVisit.add(neighbour);
                }
                current.values[i] = oldValue;
                current.values[i] = (current.values[i] - 1);
                if (current.values[i] < 0) {
                    current.values[i] = max;
                }
                Node neighbour2 = new Node(Arrays.copyOf(values, values.length));
                if (!visited.contains(neighbour2)) {
                    neighbour2.steps = current.steps + 1;
                    toVisit.add(neighbour2);
                }
            }
        }

        return -1;
    }

    static class Node {
        int[] values;
        int steps;
        List<Node> neighbours = new ArrayList<>();

        public Node(int[] values) {
            this.values = values;
        }

        boolean hasEqualValues() {

            for (int i = 1; i < values.length; i++) {
                if (values[i] != values[0]) {
                    return false;
                }
            }

            return true;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            for (int i = 0; i < values.length; i++) {
                if (this.values[i] != node.values[i]) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            int result = Arrays.hashCode(values);
            result = 31 * result + (neighbours != null ? neighbours.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return Arrays.toString(values);
        }

    }

}
