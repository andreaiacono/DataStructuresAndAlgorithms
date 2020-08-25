package datastructures;

import datastructures.node.GraphNode;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListGraph extends Graph {

    private List<GraphNode> nodes = new ArrayList<>();

    public AdjacencyListGraph(AdjacencyListGraph graph) {
        graph.getNodes().forEach(node -> nodes.add(new GraphNode(node)));
        graph.getNodes().forEach(node -> node.getEdges().forEach(edge -> nodes.get(node.getKey()).addEdge(nodes.get(edge.getDestination().getKey()))));
    }

    public AdjacencyListGraph() {
    }

    @Override
    public List<GraphNode> getNodes() {
        return nodes;
    }

    @Override
    public void addNode(GraphNode node) {
        nodes.add(node);
    }

    @Override
    public void removeNode(GraphNode node) {
        nodes.remove(node);
    }

    @Override
    public void clear() {
        nodes.clear();
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer("Graph").append("\n");
        nodes.forEach(n -> result.append("printer.Node [").append(n.getKey()).append("] -> ").append(n.getEdges()).append("\n"));
        return result.toString();
    }
}
