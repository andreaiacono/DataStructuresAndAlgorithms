package datastructures;

import datastructures.node.GraphNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdjacencyListGraphTest {

    AdjacencyListGraph graph;
    GraphNode node5;

    @Before
    public void createGraph() {
        graph = new AdjacencyListGraph();
        node5 = new GraphNode(5);
        GraphNode node6 = new GraphNode(6);
        GraphNode node2 = new GraphNode(2);
        node5.addEdge(node6);
        node5.addEdge(node2);
        node6.addEdge(node2);
        graph.addNode(node5);
        graph.addNode(node6);
        graph.addNode(node2);
    }

    @Test
    public void getNodes() throws Exception {
        assertEquals(3, graph.getNodes().size());
    }

    @Test
    public void addNode() throws Exception {
        GraphNode node9 = new GraphNode(9);
        node9.addEdge(node5);
        graph.addNode(node9);
        assertEquals(4, graph.getNodes().size());
    }

    @Test
    public void removeNode() throws Exception {
        graph.removeNode(node5);
        assertEquals(2, graph.getNodes().size());
    }

}