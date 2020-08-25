package DailyCodingProblem;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Network {
    public static void main(String[] args) {
        int n = 6;
        Map<Integer, Node> nodes = new HashMap();
        for (int j=0; j<n; j++) {
            nodes.put(j, new Node(j));
        }
        nodes.get(0).addEdge(new Edge(nodes.get(1), 5));
        nodes.get(0).addEdge(new Edge(nodes.get(2), 3));
        nodes.get(0).addEdge(new Edge(nodes.get(5), 4));
        nodes.get(1).addEdge(new Edge(nodes.get(3), 8));
        nodes.get(2).addEdge(new Edge(nodes.get(3), 1));
        nodes.get(3).addEdge(new Edge(nodes.get(5), 10));
        nodes.get(3).addEdge(new Edge(nodes.get(4), 5));

        System.out.println("shortest=" + shortestPath(nodes, nodes.get(0), nodes.get(4)));
    }

    private static int shortestPath(Map<Integer, Node> nodes, Node from, Node to) {

        Deque<Node> queue = new ArrayDeque<>();
        queue.add(from);

        Set<Node> explored = new HashSet<>();
        Set<Node> toExplore = new HashSet<>();
        toExplore.add(from);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (Node neighbour: current.edges.stream().map(edge -> edge.to).collect(toList())) {
                if (explored.contains(neighbour)) {

                }
            }

        }
        return 0;
    }
}

class Node {
    int n;
    List<Edge> edges = new ArrayList();

    public Node(int n) {
        this.n = n;
    }

    public void addEdge(Edge to) {
        edges.add(to);
    }
}

class Edge {
    Node to;
    int weight;

    public Edge(Node to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}