package datastructures.node;

import datastructures.Edge;
import datastructures.NodeStatus;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

    private int key;
    private int x;
    private int y;
    private NodeStatus status;
    private List<Edge> edges = new ArrayList<>();

    public GraphNode(int key) {
        this.key = key;
    }

    public GraphNode(GraphNode node) {
        this.key = node.getKey();
        this.x= node.getX();
        this.y= node.getY();
        this.status = node.getStatus();
    }

    public GraphNode(int index, int x, int y) {
        this.key = index;
        this.x = x;
        this.y = y;
    }

    public void addEdge(GraphNode destination) {
        Edge edge = new Edge(this, destination);
        edges.add(edge);
    }

    public int getKey() {
        return key;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setStatus(NodeStatus status) {
        this.status = status;
    }

    public NodeStatus getStatus() {
        return status;
    }

}
