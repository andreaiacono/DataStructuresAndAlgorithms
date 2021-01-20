package interviewbit;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class GraphCycleDetector {



    @Test
    public void test() {

        List<Node> nodes = IntStream
                .range(1, 8)
                .mapToObj(Node::new)
                .collect(Collectors.toList());

        Node n1 = nodes.get(0);
        Node n2 = nodes.get(1);
        Node n3 = nodes.get(2);
        Node n4 = nodes.get(3);
        Node n5 = nodes.get(4);
        Node n6 = nodes.get(5);
        Node n7 = nodes.get(6);

        n1.add(n2).add(n3);
        n2.add(n4);
        n3.add(n4).add(n6);
        n4.add(n6).add(n7);
        n5.add(n1);
        n6.add(n5);
        assertTrue(hasCycleDfs(n1, new HashSet<>()));

        cleanNodes(nodes);
        n1.add(n2);
        n2.add(n3);
        n3.add(n4);
        n4.add(n1);
        assertTrue(hasCycleDfs(n1, new HashSet<>()));

        cleanNodes(nodes);
        n1.add(n2).add(n5).add(n3);
        n2.add(n3).add(n5);
        n3.add(n4).add(n5);
        n4.add(n5);
        assertFalse(hasCycleDfs(n1, new HashSet<>()));

        cleanNodes(nodes);
        n1.add(n2).add(n3);
        n2.add(n3);
        assertFalse(hasCycleDfs(n1, new HashSet<>()));
    }

    void cleanNodes(List<Node> nodes) {
        nodes.forEach(Node::clearNeighbours);
    }


    public boolean hasCycleDfs(Node current, Set<Node> visited) {

        if (visited.contains(current)) {
            return true;
        }

        visited.add(current);

        for (Node neighbour: current.neighbors) {
            if (hasCycleDfs(neighbour, visited)) {
                return true;
            }
        }

        visited.remove(current);

        return false;
    }

    class Node {
        int val;
        Set<Node> neighbors = new HashSet<>();

        Node(int val) {
            this.val = val;
        }

        public Node add(Node child) {
            neighbors.add(child);
            return this;
        }

        public void clearNeighbours() {
            neighbors.clear();
        }

        @Override
        public String toString() {
            return "[" + val + "]";
        }

        @Override
        public boolean equals(Object o) {
            Node node = (Node) o;
            return val == node.val;
        }

        @Override
        public int hashCode() {
            return val * 31;
        }
    }

    public boolean detectCycle3(Node start) {

        Set<Node> visitedNodes = new HashSet<>();
        Deque<Node> unvisitedNodes = new ArrayDeque<>();
        Deque<Node> backEdges = new ArrayDeque<>();
        unvisitedNodes.push(start);
        visitedNodes.add(start);
//        backEdges.push(start);

        while (!unvisitedNodes.isEmpty()) {
            Node current = unvisitedNodes.pop();
            System.out.println("After popping " + current + " Stack: " + unvisitedNodes + " - Backedges: " + backEdges);
            boolean addedNeighbors = false;
            backEdges.push(current);

            for (Node child : current.neighbors) {
                if (backEdges.contains(child)) {
                    return true;
                }
                if (!visitedNodes.contains(child)) {
                    addedNeighbors = true;
                    visitedNodes.add(child);
                    unvisitedNodes.push(child);
                    System.out.println("Pushed child " + child);
                }
            }
            if (!addedNeighbors) {
                System.out.println("Popping out from Backedges: " + backEdges.peek());
                backEdges.pop();
            }
        }

        return false;
    }

    public boolean detectCycle2(Node node) {
        Set<Node> visited = new HashSet<>();
        return dfs(node, visited);
    }


    public boolean dfs(Node node, Set<Node> visited) {

        visited.add(node);

        for (Node child : node.neighbors) {
            if (!visited.contains(child)) {
                if (dfs(child, visited)) {
                    return true;
                }
            }
            else {
                return true;
            }
        }

        visited.remove(node);
        return false;
    }

}
