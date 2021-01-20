package graph;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountCycles {

    /**
     * Given an undirected and connected graph and a number n, count total number of cycles of length n in the graph.
     * A cycle of length n simply means that the cycle contains n vertices and n edges.
     */

    @Test
    public void test() {
        List<Node> nodes = IntStream
                .range(1, 8)
                .mapToObj(Node::new)
                .collect(Collectors.toList());

        Node n1 = nodes.get(0);
        Node n2 = nodes.get(1);
        Node n3 = nodes.get(2);
        Node n4 = nodes.get(3);
        Node n5 = nodes.get(4);
        Node n6 = nodes.get(5);
        Node n7 = nodes.get(6);

    }

    List<Integer> countCycles(Node start) {

        return null;

    }

}
