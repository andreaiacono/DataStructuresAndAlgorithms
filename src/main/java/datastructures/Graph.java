package datastructures;

import datastructures.node.GraphNode;

import java.util.List;

public abstract class Graph {

    public abstract List<GraphNode> getNodes();

    public abstract void addNode(GraphNode node);

    public abstract void removeNode(GraphNode node);

    public abstract void clear();
}
