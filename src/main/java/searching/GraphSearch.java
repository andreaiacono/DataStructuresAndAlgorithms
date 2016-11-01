package searching;

import datastructures.Edge;
import datastructures.Graph;
import datastructures.NodeStatus;
import datastructures.node.GraphNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 14/07/14
 * Time: 16.08
 */
public class GraphSearch {

    private int vertexCount;
    private LocalGraphNode root;

    class LocalGraphNode {
        VertexState status;
    }

    enum VertexState {
        VISITED, IN_PROGRESS, NOT_VISITED
    }

    public void depthFirstSearch() {
        VertexState state[] = new VertexState[vertexCount];
        for (int i = 0; i < vertexCount; i++)
            state[i] = VertexState.NOT_VISITED;
        recursiveDepthFirstSearch(0, state);
    }

    public void recursiveDepthFirstSearch(int u, VertexState[] state) {
        state[u] = VertexState.IN_PROGRESS;
        for (int v = 0; v < vertexCount; v++)
            if (isEdge(u, v) && state[v] == VertexState.NOT_VISITED)
                recursiveDepthFirstSearch(v, state);
        state[u] = VertexState.VISITED;
    }


    public void iterativeDepthFirstSearch() {

        List<LocalGraphNode> nodes = new ArrayList<>();
        Deque<LocalGraphNode> stack = new ArrayDeque<>();
        stack.push(root);
        root.status = VertexState.VISITED;
        nodes.add(root);

        while (!stack.isEmpty()) {
            LocalGraphNode node = stack.peek();
            LocalGraphNode child = null; //getUnvisitedChildNode(node);
            if (child != null) {
                child.status = VertexState.VISITED;
                nodes.add(node);
                stack.push(child);
            }
            else {
                stack.pop();
            }
        }
    }

    public static void bfs(Graph graph, Consumer<GraphNode> onVisitedNode, Consumer<Edge> onVisitedEdge, Consumer<GraphNode> onProcessedNode) {
        genericFirstSearch(graph,
                (queue, node) -> queue.add(node),
                (queue) -> (GraphNode) queue.poll(),
                onVisitedNode,
                onVisitedEdge,
                onProcessedNode);
    }

    public static void dfs(Graph graph, Consumer<GraphNode> onVisitedNode, Consumer<Edge> onVisitedEdge, Consumer<GraphNode> onProcessedNode) {
        genericFirstSearch(graph,
                (stack, node) -> stack.push(node),
                (stack) -> (GraphNode) stack.pop(),
                onVisitedNode,
                onVisitedEdge,
                onProcessedNode);
    }

    public static void genericFirstSearch(Graph graph, BiConsumer<Deque, GraphNode> nodePutter, Function<Deque, GraphNode> nodeGetter, Consumer<GraphNode> onVisitedNode, Consumer<Edge> onVisitedEdge, Consumer<GraphNode> onProcessedNode) {

        graph.getNodes().forEach(node -> node.setStatus(NodeStatus.UNKNOWN));
        Deque<GraphNode> queue = new ArrayDeque<>();
        nodePutter.accept(queue, graph.getNodes().get(0));

        while (!queue.isEmpty()) {
            GraphNode node = nodeGetter.apply(queue);
            node.setStatus(NodeStatus.DISCOVERED);
            onVisitedNode.accept(node);
            for (Edge edge: node.getEdges()) {
                if ((edge.getDestination()).getStatus() == NodeStatus.UNKNOWN) {
                    nodePutter.accept(queue, edge.getDestination());
                    (edge.getDestination()).setStatus(NodeStatus.DISCOVERED);
                    onVisitedEdge.accept(edge);
                }
            }
            node.setStatus(NodeStatus.PROCESSED);
            onProcessedNode.accept(node);
        }
    }

    public boolean isEdge(int u, int v) {
        return true;
    }

}
