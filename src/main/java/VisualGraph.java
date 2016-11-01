import datastructures.AdjacencyListGraph;
import datastructures.Edge;
import datastructures.NodeStatus;
import datastructures.node.GraphNode;
import searching.GraphSearch;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class VisualGraph extends JFrame implements ChangeListener {

    enum SearchType {
        DFS, BFS;
    }

    private final JLabel statusBar;
    private final JSplitPane spDivider;
    private final DrawingPanel drawingPanel;

    public static void main(String[] args) throws Exception {
        new VisualGraph();
    }

    public VisualGraph() throws Exception {

        super("Visual Graph");

        setSize(900, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");

        // control and drawing panels
        drawingPanel = new DrawingPanel();
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        JButton startButton = new JButton("Reset");
        startButton.addActionListener(e -> drawingPanel.reset());
        controlPanel.add(startButton);
        JButton animateButton = new JButton("Animate");
        animateButton.addActionListener(e -> drawingPanel.animate());
        controlPanel.add(animateButton);
        JButton resetButton = new JButton("New Graph");
        resetButton.addActionListener(e -> drawingPanel.newGraph());
        controlPanel.add(resetButton);
        JLabel speedLabel = new JLabel("Speed: ");
        controlPanel.add(speedLabel);
        JSlider speedSlider = new JSlider(JSlider.HORIZONTAL, 0, 500, 50);
        speedSlider.setName("speed");
        drawingPanel.setSpeed(50);
        controlPanel.add(speedSlider);
        speedSlider.addChangeListener(this);

        JLabel nodesLabel = new JLabel("# of Nodes: ");
        controlPanel.add(nodesLabel);
        JSlider nodesSlider = new JSlider(JSlider.HORIZONTAL, 10, 500, 100);
        nodesSlider.setName("nodes");
        drawingPanel.setNodesNumber(100);
        controlPanel.add(nodesSlider);
        nodesSlider.addChangeListener(this);

        JLabel edgeLabel = new JLabel("# of Edges: ");
        controlPanel.add(edgeLabel);
        JSlider edgeSlider = new JSlider(JSlider.HORIZONTAL, 1, 100, 10);
        edgeSlider.setName("edges");
        drawingPanel.setEdgesNumber(10);
        controlPanel.add(edgeSlider);
        edgeSlider.addChangeListener(this);

        spDivider = new JSplitPane(JSplitPane.VERTICAL_SPLIT, drawingPanel, controlPanel);
        spDivider.setDividerLocation(450);
        add(spDivider, BorderLayout.CENTER);

        // sets the status bar
        statusBar = new JLabel(" Ready");
        add("South", statusBar);

        // starts
        setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        if (slider.getName().equals("speed")) {
            drawingPanel.setSpeed(slider.getValue());
        }
        else if (slider.getName().equals("nodes")) {
            drawingPanel.setNodesNumber(slider.getValue());
        }
        else if (slider.getName().equals("edges")) {
            drawingPanel.setEdgesNumber(slider.getValue());
        }
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        spDivider.setDividerLocation((getSize().getHeight() * 0.9) / getSize().getHeight());
    }

    private class DrawingPanel extends JPanel {

        private final GraphPanel bfsGraph;
        private final GraphPanel dfsGraph;
        private int edgesNumber = 8;
        private int nodesNumber = 100;

        public DrawingPanel() {

            FlowLayout flowLayout = new FlowLayout();
            setLayout(flowLayout);

            AdjacencyListGraph graph = createRandomGraph();
            dfsGraph = new GraphPanel(SearchType.DFS, this, new AdjacencyListGraph(graph));
            add(dfsGraph);
            bfsGraph = new GraphPanel(SearchType.BFS, this, new AdjacencyListGraph(graph));
            add(bfsGraph);
        }

        private AdjacencyListGraph createRandomGraph() {
            int canvasSize = 500;
            Random random = new Random();
            AdjacencyListGraph graph = new AdjacencyListGraph();
            for (int j = 0; j < nodesNumber; j++) {
                GraphNode node = new GraphNode(j, random.nextInt(canvasSize), random.nextInt(canvasSize));
                graph.addNode(node);
            }

            List<GraphNode> nodes = graph.getNodes();
            for (int i = 0; i < nodes.size(); i++) {
                int[] selectedEdges = new int[edgesNumber];
                GraphNode currentNode = nodes.get(i);
                for (int k = 0; k < edgesNumber; k++) {
                    if (random.nextBoolean()) {
                        int min = Integer.MAX_VALUE;
                        int index = 0;
                        for (int j = 0; j < nodes.size(); j++) {
                            final int jj = j;
                            if (i == j || IntStream.of(selectedEdges).anyMatch(x -> x == jj)) continue;
                            GraphNode node = nodes.get(j);
                            int distance = Math.abs(node.getX() - currentNode.getX()) + Math.abs(node.getY() - currentNode.getY());
                            if (distance < min) {
                                min = distance;
                                index = j;
                            }
                        }
                        selectedEdges[k] = index;
                        currentNode.addEdge(nodes.get(index));
                    }
                }
            }
            return graph;
        }

        public void reset() {
            dfsGraph.reset();
            bfsGraph.reset();
        }

        public void newGraph() {
            AdjacencyListGraph graph = createRandomGraph();
            bfsGraph.setGraph(new AdjacencyListGraph(graph));
            dfsGraph.setGraph(new AdjacencyListGraph(graph));
        }

        public void animate() {
            dfsGraph.animate();
            bfsGraph.animate();
        }

        public void setSpeed(int speed) {
            bfsGraph.setSpeed(speed);
            dfsGraph.setSpeed(speed);
        }

        public void setEdgesNumber(int edgesNumber) {
            this.edgesNumber = edgesNumber;
        }

        public void setNodesNumber(int nodesNumber) {
            this.nodesNumber = nodesNumber;
        }
    }

    private class GraphPanel extends JPanel {

        private DrawingPanel drawingPanel;
        private AdjacencyListGraph graph;
        private int side;
        private List<GraphNode> visitedNodes = new ArrayList<>();
        private List<Edge> visitedEdges = new ArrayList<>();
        private List<GraphNode> processedNodes = new ArrayList<>();
        private SearchType searchType;
        private int speed;

        public GraphPanel(SearchType searchType, DrawingPanel drawingPanel, AdjacencyListGraph graph) {
            this.searchType = searchType;
            this.drawingPanel = drawingPanel;
            this.graph = graph;
            setBorder(BorderFactory.createEtchedBorder());
            setBackground(new Color(230, 230, 230));
        }

        public void setGraph(AdjacencyListGraph graph) {
            this.graph = graph;
            visitedEdges = new ArrayList<>();
            visitedNodes = new ArrayList<>();
            processedNodes = new ArrayList<>();
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // makes a local copy of data to avoid concurrent modifications
            List<Edge> edges = new ArrayList<>(visitedEdges);

            double mf = getPreferredSize().getHeight() / 500;
            Graphics2D g2 = (Graphics2D) g;
            float color = 0;
            g2.setStroke(new BasicStroke(1));

            graph.getNodes().forEach(node -> node.getEdges().forEach(edge -> drawEdge(g2, edge, mf, Color.BLACK)));

            float increment = 255 / (edges.size() != 0 ? new Float(edges.size()) : 255f);
            g2.setStroke(new BasicStroke(3));
            for (Edge edge : edges) {
                color += increment;
                drawEdge(g2, edge, mf, new Color((int) color, (int) color, 255));
            }
            g2.setStroke(new BasicStroke(1));

            graph.getNodes().forEach(node -> {
                drawNode(g2, mf, node, null);
            });

            if (graph.getNodes().size() > 0) {
                drawNode(g2, mf, graph.getNodes().get(0), Color.GREEN);
            }
            g.drawString(searchType.toString(), 5, 15);

        }

        private void drawNode(Graphics g, double mf, GraphNode node, Color color) {
            int size = (int) (6 * mf);
            if (color != null) {
                g.setColor(color);
            }
            else {
                if (node.getStatus() == NodeStatus.UNKNOWN) g.setColor(Color.RED);
                if (node.getStatus() == NodeStatus.DISCOVERED) g.setColor(Color.GRAY);
                if (node.getStatus() == NodeStatus.PROCESSED) g.setColor(new Color(245, 245, 245));
            }
            g.fillOval(((int) (node.getX() * mf)) - size, ((int) (node.getY() * mf)) - size, size * 2, size * 2);
            g.setColor(Color.BLACK);
            g.drawOval(((int) (node.getX() * mf)) - size, ((int) (node.getY() * mf)) - size, size * 2, size * 2);
        }

        private void drawEdge(Graphics g, Edge edge, double mf, Color edgeColor) {
            g.setColor(edgeColor);
            GraphNode sourceNode = ((GraphNode) edge.getSource());
            GraphNode destinationNode = ((GraphNode) edge.getDestination());
            g.drawLine(
                    (int) (sourceNode.getX() * mf),
                    (int) (sourceNode.getY() * mf),
                    (int) (destinationNode.getX() * mf),
                    (int) (destinationNode.getY() * mf));
        }

        @Override
        public Dimension getPreferredSize() {
            Dimension dimension = drawingPanel.getSize();
            side = dimension.width < dimension.height * 2 ? dimension.width / 2 - 10 : dimension.height - 10;
            return new Dimension(side, side);
        }


        public void reset() {
            visitedNodes = new ArrayList<>();
            visitedEdges = new ArrayList<>();
            processedNodes = new ArrayList<>();

            Consumer<GraphNode> visitNode = node -> visitedNodes.add(node);
            Consumer<Edge> visitEdge = edge -> visitedEdges.add(edge);
            Consumer<GraphNode> processNode = node -> processedNodes.add(node);

            switch (searchType) {
                case DFS:
                    GraphSearch.dfs(graph, visitNode, visitEdge, processNode);
                    break;
                case BFS:
                    GraphSearch.bfs(graph, visitNode, visitEdge, processNode);
                    break;
            }
            repaint();
        }

        private void updateGraph() {
            repaint();
            if (speed > 0) {
                try {
                    Thread.sleep(speed);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void animate() {
            visitedEdges = new ArrayList<>();
            visitedNodes = new ArrayList<>();
            processedNodes = new ArrayList<>();
            repaint();
            new GraphSearchWorker(visitedNodes, visitedEdges, processedNodes).execute();
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        class GraphSearchWorker extends SwingWorker<Void, Void> {

            List<GraphNode> visitedNodes;
            List<Edge> visitedEdges;
            List<GraphNode> processedNodes;

            public GraphSearchWorker(List<GraphNode> visitedNodes, List<Edge> visitedEdges, List<GraphNode> processedNodes) {
                this.visitedNodes = visitedNodes;
                this.visitedEdges = visitedEdges;
                this.processedNodes = processedNodes;
            }

            @Override
            protected Void doInBackground() throws Exception {

                Consumer<GraphNode> visitNode = node -> visitedNodes.add(node);
                Consumer<GraphNode> processNode = node -> processedNodes.add(node);
                Consumer<Edge> visitEdge = edge -> {
                    visitedEdges.add(edge);
                    updateGraph();
                };

                switch (searchType) {
                    case BFS:
                        GraphSearch.bfs(graph, visitNode, visitEdge, processNode);
                        break;
                    case DFS:
                        GraphSearch.dfs(graph, visitNode, visitEdge, processNode);
                        break;
                }

                updateGraph();
                return null;
            }

        }
    }
}
