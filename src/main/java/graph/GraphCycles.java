package graph;

import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class GraphCycles {

    @Test
    public void test() {
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        GraphNode node5 = new GraphNode(5);
        GraphNode node6 = new GraphNode(6);
        GraphNode node7 = new GraphNode(7);
        GraphNode node8 = new GraphNode(8);
        node1.neighbours.add(node2);
        node2.neighbours.add(node3);
        node3.neighbours.add(node4);
        node3.neighbours.add(node5);
        node3.neighbours.add(node7);
        node5.neighbours.add(node6);
        node5.neighbours.add(node8);
        assertFalse(hasCycle(node1));
        assertFalse(hasCycleBfs(node1));

        node6.neighbours.add(node2);
        assertTrue(hasCycle(node1));
        assertTrue(hasCycleBfs(node1));
    }

    boolean hasCycle(GraphNode start) {
        return hasCycle(start, new HashSet<>());
    }

    boolean hasCycle(GraphNode current, Set<GraphNode> visited) {

        visited.add(current);

        boolean result = false;
        for (GraphNode neighbour : current.neighbours) {
            if (visited.contains(neighbour)) {
                return true;
            }
            result = result || hasCycle(neighbour, visited);
        }
        return result;
    }

    boolean hasCycleBfs(GraphNode start) {

        Set<GraphNode> visited = new HashSet<>();
        Deque<GraphNode> queue = new ArrayDeque<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {

            GraphNode current = queue.poll();
            visited.add(current);

            for (GraphNode neighbour: current.neighbours) {

                if (!visited.contains(neighbour)) {
                    queue.add(neighbour);
                }
                else {
                    return true;
                }
            }
        }

        return false;
    }

    class GraphNode {
        int val;
        List<GraphNode> neighbours = new ArrayList<>();

        public GraphNode(int val) {
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

            GraphNode graphNode = (GraphNode) o;

            if (val != graphNode.val) return false;
            return neighbours != null ? neighbours.equals(graphNode.neighbours) : graphNode.neighbours == null;
        }

        @Override
        public int hashCode() {
            return 31 * val;
        }
    }
}
