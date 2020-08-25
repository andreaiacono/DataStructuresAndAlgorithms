package dynamicprogramming;


import java.util.*;

// https://medium.com/@alexgolec/google-interview-problems-ratio-finder-d7aa8bf201e3
public class Ratio {

    public double ratio(Node from, Node to) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(from);

        Set<Node> visited = new HashSet<>();
        visited.add(from);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.equals(to)) {
                to.parent = current;
                return computeRatio(to);
            }

            for (Edge edge: current.neighbours) {
                if (!visited.contains(edge.to)) {
                    edge.to.parent = current;
                    queue.add(edge.to);
                }
            }
        }
        return 0;
    }

    public double computeRatio(Node node) {
        double ratio = 1;
        while (node.parent != null) {
            ratio *= getRatio(node.parent, node);
        }
        return ratio;
    }

    private double getRatio(Node from, Node to) {
        for (Edge neighbour: from.neighbours) {
            if (neighbour.to.equals(to)) {
                return neighbour.weight;
            }
        }
        return 0;
    }

}


class Edge {
    double weight;
    Node from;
    Node to;
    // constructore
}
class Node {
    String unit;
    Node parent;
    List<Edge> neighbours = new ArrayList<>();

    public Node(String unit) {
        this.unit = unit;
    }

    // equals, hashCode implementation
}
