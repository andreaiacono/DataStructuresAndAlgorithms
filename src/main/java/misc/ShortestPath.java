package misc;

import java.util.*;
import java.util.function.Consumer;

public class ShortestPath {

    // Dijkstra shortest path algorithm
    public List<Node> shortestPath(Graph graph, Node startingNode, Node targetNode) {
        dijkstra(startingNode, targetNode);
        Deque<Node> result = new ArrayDeque<>();
        Node current = targetNode;
        while (current != null) {
            result.addFirst(current);
            current = current.parent;
        }
        return new ArrayList<>() {{ addAll(result); }};
    }

    // O(|V^2|)
    public void dijkstra(Node startingNode, Node targetNode) {

        PriorityQueue<Node> toBeVisited = new PriorityQueue<>(Comparator.comparingDouble(n -> n.pathCost));
        startingNode.pathCost = 0;
        while (!toBeVisited.isEmpty()) {

            Node node = toBeVisited.poll();
            if (node.equals(targetNode)) {
                return;
            }

            for (Edge edge : node.neighbourEdges) {
                double newCost = node.pathCost + edge.cost;
                Node destinationNode = edge.to;

                if (newCost < destinationNode.pathCost) {
                    destinationNode.pathCost = newCost;
                    destinationNode.parent = edge.from;

                    // no dynamic recomputation of priority in java.util.PriorityQueue,
                    // so remove and re-insert
                    if (toBeVisited.remove(destinationNode)) {
                        toBeVisited.add(destinationNode);
                    }
                }
            }
        }
    }

    class Graph {
        List<Node> adjList = new ArrayList<>();

        void clear() {
            for (Node node: adjList) {
                node.pathCost = Integer.MAX_VALUE;
                node.parent = null;
            }
        }
    }

    class Edge {
        double cost;
        Node from;
        Node to;

        public Edge(double cost, Node from, Node to) {
            this.cost = cost;
            this.from = from;
            this.to = to;
        }
    }

    class Node {
        int val;
        List<Edge> neighbourEdges = new ArrayList<>();
        int status;
        double pathCost;
        Node parent;

        public Node(int val) {
            this.val = val;
        }

        // equals
    }

}
