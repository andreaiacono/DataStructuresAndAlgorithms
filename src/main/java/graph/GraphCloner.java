package graph;

import com.google.common.base.Objects;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class GraphCloner {


    @Test
    public void test() {

        Node node0 = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        Node node7 = new Node(8);
        node0.neighbours.add(node1);
        node0.neighbours.add(node2);
        node1.neighbours.add(node0);
        node1.neighbours.add(node3);
        node1.neighbours.add(node6);
        node2.neighbours.add(node6);
        node3.neighbours.add(node1);
        node3.neighbours.add(node2);
        node3.neighbours.add(node5);
        node3.neighbours.add(node6);
        node4.neighbours.add(node6);
        node5.neighbours.add(node1);
        node5.neighbours.add(node4);
        node5.neighbours.add(node7);
        node6.neighbours.add(node0);
        node6.neighbours.add(node2);
        node6.neighbours.add(node5);
        node6.neighbours.add(node7);
        node7.neighbours.add(node6);
        node7.neighbours.add(node4);

        String expected = traverse(node0);
        System.out.println(expected);

        Node clonedNode0 = clone(node0);
        String clonedBfs = traverse(clonedNode0);
        System.out.println(clonedBfs);

        assertEquals(expected, clonedBfs);
    }

    Node clone(Node start) {
        Set<Node> visited = new HashSet<>();
        Deque<Node> toVisit = new ArrayDeque<>();
        visited.add(start);
        toVisit.add(start);

        Map<Integer, Node> clonedGraph = new HashMap<>();
        clonedGraph.put(start.val, new Node(start.val));

        while (!toVisit.isEmpty()) {

            Node current = toVisit.poll();
            Node currentClone = clonedGraph.get(current.val);

            for (Node neighbour : current.neighbours) {
                if (!visited.contains(neighbour)) {
                    Node clonedNeighbour = new Node(neighbour.val);
                    clonedGraph.put(neighbour.val, clonedNeighbour);
                    currentClone.neighbours.add(clonedGraph.get(neighbour.val));
                    toVisit.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }

        return clonedGraph.get(start.val);
    }


    String traverse(Node start) {

        StringBuilder result = new StringBuilder();
        Set<Node> visited = new HashSet<>();
        visited.add(start);
        Deque<Node> toVisit = new ArrayDeque<>();
        toVisit.add(start);

        while (!toVisit.isEmpty()) {
            Node current = toVisit.poll();

            result.append(current.val).append(" ");

            for (Node neighbour : current.neighbours) {
                if (!visited.contains(neighbour)) {
                    toVisit.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }

        return result.toString().trim();
    }

    class Node {
        int val;
        List<Node> neighbours = new ArrayList<>();

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "" + val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (val != node.val) return false;
            return neighbours != null ? neighbours.equals(node.neighbours) : node.neighbours == null;
        }

        @Override
        public int hashCode() {
            int result = val;
            result = 31 * result;
            return result;
        }
    }

}
