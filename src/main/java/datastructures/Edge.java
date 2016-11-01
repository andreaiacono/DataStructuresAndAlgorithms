package datastructures;

import datastructures.node.GraphNode;

public class Edge {
    private GraphNode source;
    private GraphNode destination;

    public Edge(GraphNode source, GraphNode destination) {
        this.source = source;
        this.destination = destination;
    }

    public GraphNode getSource() {
        return source;
    }

    public GraphNode getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "" + destination.getKey();
    }
}
