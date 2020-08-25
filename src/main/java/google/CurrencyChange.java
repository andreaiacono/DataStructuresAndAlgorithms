package google;

import com.google.common.base.Objects;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class CurrencyChange {

    /**
     * Interview #2
     * Given a set of label/label/ratio and a set of queries, return the values of the queries. Input:
     * Labels
     * EUR / GBP / 0.5
     * GBP / CHF / 0.2
     * Queries:
     * EUR / CHF
     * Output:
     * EUR /CHF / 0.1
     */

    @Test
    public void test() {
        List<String> input = List.of(
                "EUR/GBP/0.5",
                "EUR/USD/0.2",
                "GBP/USD/0.4",
                "GBP/CHF/0.2",
                "JPY/EUR/0.8"
        );

        assertEquals(0.1d, getRatio("EUR", "CHF", toGraph(input)), 0.001);
        assertEquals(1.25d, getRatio("EUR", "JPY", toGraph(input)), 0.001);
        assertEquals(6.25d, getRatio("USD", "JPY", toGraph(input)), 0.001);
    }


    Map<String, Node> toGraph(List<String> input) {
        Map<String, Node> graph = new HashMap<>();
        for (String row : input) {

            // assumes sanitized input
            String[] tokens = row.replaceAll(" ", "").split("/");
            String currencyFrom = tokens[0];
            String currencyTo = tokens[1];
            double ratio = Double.valueOf(tokens[2]);

            Node from = graph.get(currencyFrom);
            if (from == null) {
                from = new Node(currencyFrom);
                graph.put(currencyFrom, from);
            }

            Node to = graph.get(currencyTo);
            if (to == null) {
                to = new Node(currencyTo);
                graph.put(currencyTo, to);
            }
            from.edges.add(new Edge(ratio, to));
            to.edges.add(new Edge(1/ratio, from));
        }

        System.out.println(graph);
        return graph;
    }

    double getRatio(String fromCurr, String toCurr, Map<String, Node> graph) {

        // assumes sanitized input
        Node from = graph.get(fromCurr);
        Node to = graph.get(toCurr);

        Set<Node> visited = new HashSet<>();
        visited.add(from);

        Deque<Node> queue = new ArrayDeque<>();
        queue.add(from);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == to) {
                queue.clear();
                break;
            }
            for (Edge edge : current.edges) {
                if (!visited.contains(edge.to)) {
                    edge.to.parent = current;
                    queue.add(edge.to);
                    visited.add(edge.to);
                }
            }
        }

        Node backRunner = to;
        double weight = 1;
        while (backRunner.parent != null) {
            weight *= backRunner.parent.getEdge(backRunner).weight;
            System.out.println(backRunner.parent.currency + " -> " + backRunner.currency + ": " + weight);
            backRunner = backRunner.parent;
        }
        return weight;
    }


    class Node {
        String currency;
        List<Edge> edges = new ArrayList<>();
        Node parent;

        public Node(String currency) {
            this.currency = currency;
        }

        Edge getEdge(Node to) {
            for (Edge edge : edges) {
                if (edge.to.equals(to)) {
                    return edge;
                }
            }

            return null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return currency != null ? currency.equals(node.currency) : node.currency == null;
        }

        @Override
        public int hashCode() {
            return currency != null ? currency.hashCode() : 0;
        }

        @Override
        public String toString() {
            return currency + " -> " + edges;
        }

        // equals, hashCode
    }

    class Edge {
        double weight;
        Node to;

        public Edge(double weight,Node to) {
            this.weight = weight;
            this.to = to;
        }

        @Override
        public String toString() {
            return "(" + to.currency + "/" + weight + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Edge edge = (Edge) o;

            if (Double.compare(edge.weight, weight) != 0) return false;
            return to != null ? to.equals(edge.to) : edge.to == null;
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            temp = Double.doubleToLongBits(weight);
            result = (int) (temp ^ (temp >>> 32));
            result = 31 * result + (to != null ? to.hashCode() : 0);
            return result;
        }
    }

}
