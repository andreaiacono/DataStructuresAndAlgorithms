package interviewbit;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertFalse;

public class GraphCycleDetector {

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

    @Test
    public void test() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
//        n1.add(n2).add(n3);
//        n2.add(n4);
//        n3.add(n4);
//        n4.add(n2).add(n5).add(n6).add(n7);
//        n5.add(n4);
//        n6.add(n5);
//        assertTrue(detectCycle(n1));
//
//        n1 = new printer.Node(1);
//        n2 = new printer.Node(2);
//        n3 = new printer.Node(3);
//        n4 = new printer.Node(4);
//        n1.add(n2);
//        n2.add(n3);
//        n3.add(n4);
//        n4.add(n1);
//        assertTrue(detectCycle(n1));

//        n1 = new printer.Node(1);
//        n2 = new printer.Node(2);
//        n3 = new printer.Node(3);
//        n4 = new printer.Node(4);
//        n5 = new printer.Node(5);
//        n1.add(n2).add(n5);
//        n2.add(n3).add(n5);
//        n3.add(n4);
//        n4.add(n5);
//        assertFalse(detectCycle(n1));

        n1 = new Node(1);
        n2 = new Node(2);
        n3 = new Node(3);
        n4 = new Node(4);
        n1.add(n2).add(n3);
        n2.add(n3);
        n3.add(n4);
        assertFalse(detectCycle(n1, new ArrayDeque<>(Arrays.asList(n1,n2,n3))));
//        assertFalse(detectCycle(n1));
    }

    public boolean detectCycle(Node start, Deque<Node> unvisitedNodes) {

        while (!unvisitedNodes.isEmpty()) {
            Node node = unvisitedNodes.pop();
            Deque<Node> stack = new ArrayDeque<>();
            stack.push(node);
            while (!stack.isEmpty()) {
                Node top = stack.pop();
                boolean addedNeighbor = false;
                for (Node neighbor : top.neighbors) {
                    if (stack.contains(neighbor)) {
                        return true;
                    }
                    if (unvisitedNodes.contains(neighbor)) {
                        stack.push(neighbor);
                        unvisitedNodes.remove(neighbor);
                        addedNeighbor = true;
                        break;
                    }
                }
                if (!addedNeighbor) {
                    stack.pop();
                }
            }
        }
        return false;
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
