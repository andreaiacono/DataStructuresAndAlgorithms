package graph;

import java.util.HashSet;
import java.util.Set;

public class Node {
    int val;
    public Set<Node> neighbours = new HashSet<>();

    public Node(int val) {
        this.val = val;
    }

    public Node add(Node child) {
        neighbours.add(child);
        return this;
    }

    public void clearNeighbours() {
        neighbours.clear();
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