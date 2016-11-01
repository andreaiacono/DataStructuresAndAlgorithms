import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 *
 * Codingame: The Labyrinth ( https://www.codingame.com/training/hard/the-labyrinth )
 **/
class Player {

    static final char UNKNOWN = '?';
    static final char WALL = '#';
    static final char EMPTY = '.';
    static final char START = 'T';
    static final char CONTROL_ROOM = 'C';
    static final Position UNDEFINED_POSITION = new Position(-1, -1);
    static final Node UNDEFINED_NODE = new Node(UNDEFINED_POSITION);
    static int R;
    static int C;
    static List<Node> nodes = new ArrayList<>();
    static List<Position> visitedPositions = new ArrayList<>();

    static class Position {
        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        void setPosition(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public String toString() { return "(" + row + "," + col + ")"; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            if (row != position.row) return false;
            return col == position.col;
        }

        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + col;
            return result;
        }
    }

    enum Status {
        SEARCHING, GOING_TO_CONTROL_ROOM, GOING_TO_START;
    }

    static class Node {
        enum Status {UNKNOWN, DISCOVERED}

        Position pos;
        List<Node> nodes = new ArrayList<>();
        Status status = Status.UNKNOWN;
        Node parent;
        boolean isSearched = false;

        public Node(Position pos) {
            this.pos = pos;
        }

        void addNode(Node node) {
            nodes.add(node);
        }

        public String toString() { return "(" + pos.row + "," + pos.col + ")"; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return pos != null ? pos.equals(node.pos) : node.pos == null;

        }

        @Override
        public int hashCode() {
            return pos != null ? pos.hashCode() : 0;
        }
    }

    public static void main(String args[]) {

        char[][] m = new char[100][200];
        List path = new ArrayList();
        Function<Position, Boolean> pathFilter = pos -> m[pos.row][pos.col] != UNKNOWN && m[pos.row][pos.col] != WALL ;

        Position me = new Position(-1, -1);
        Position startPosition = new Position(-1, -1);
        Position controlRoom = new Position(-1, -1);
        Node startingNode = UNDEFINED_NODE;
        Node controlRoomNode = UNDEFINED_NODE;

        Status status = Status.SEARCHING;

        Scanner in = new Scanner(System.in);
        R = in.nextInt(); // number of rows.
        C = in.nextInt(); // number of columns.
        int A = in.nextInt(); // number of rounds between the time the alarm countdown is activated and the time the alarm goes off.

        // game loop
        while (true) {
            me.setPosition(in.nextInt(), in.nextInt());
            path.add(new Position(me.row, me.col));

            if (startPosition.equals(UNDEFINED_POSITION)) {
                startPosition = new Position(me.row, me.col);
                startingNode = new Node(startPosition);
                visitedPositions.add(startPosition);
            }
            for (int i = 0; i < R; i++) {
                String row = in.next(); // C of the characters in '#.TC?' (i.e. one line of the ASCII maze).
                updateMaze(row, i, m);
                if (controlRoom.equals(UNDEFINED_POSITION) && row.indexOf(CONTROL_ROOM) >= 0) {
                    controlRoom.setPosition(i, row.indexOf(CONTROL_ROOM));
                    controlRoomNode = new Node(controlRoom);
                    status = Status.GOING_TO_CONTROL_ROOM;
                }

                if (!me.equals(startPosition) && me.equals(controlRoom)) {
                    status = Status.GOING_TO_START;
                }
            }
            printMaze(m, me, controlRoom);
            updateGraph(m, startingNode, pathFilter);
            List<Position> moves = getMoves(me, controlRoomNode, startingNode, status, path, pathFilter, m);
            System.err.println("Status=" + status + " Available moves: " + moves);
            System.out.println(getDirection(me, moves.get(0)));
            visitedPositions.add(moves.get(0));
        }
    }

    private static void printMaze(char[][] m, Position me, Position controlRoom) {
        System.err.println("I am in " + me + (controlRoom.row != -1 ? " - ControlRoom: " + controlRoom : ""));
        for (int j = 0; j < R; j++) {
            for (int i = 0; i < C; i++) {
                System.err.print(m[j][i]);
            }
            System.err.println("");
        }
    }

    private static void updateNodes(char[][] m, Node startingNode, Node node, Function<Position, Boolean> pathFilter) {
        List<Position> neighbours = getNeighbours(node.pos, pathFilter);
        neighbours.forEach(n -> {
            if (!isPresent(startingNode, n)) {
                Node neighbour = new Node(n);
                node.addNode(neighbour);
                neighbour.addNode(node);
                nodes.add(neighbour);
                updateNodes(m, startingNode, neighbour, pathFilter);
            }
        });
    }

    // uses BFS to find if a node is already present in graph
    static boolean isPresent(Node startingNode, Position searchedPosition) {

        nodes.forEach(n -> n.isSearched = false);

        Deque<Node> queue = new ArrayDeque<>();
        queue.add(startingNode);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode.pos.equals(searchedPosition)) {
                return true;
            }
            currentNode.status = Node.Status.DISCOVERED;
            for (Node connectedNode : currentNode.nodes) {
                if (!connectedNode.isSearched) {
                    queue.add(connectedNode);
                    connectedNode.isSearched = true;
                    connectedNode.status = Node.Status.DISCOVERED;
                }
            }
        }

        return false;
    }

    private static void updateGraph(char[][] m, Node startingNode, Function<Position, Boolean> pathFilter) {

        // cleans all the referrals to other nodes
        nodes.clear();
        startingNode = new Node(startingNode.pos);

        nodes.add(startingNode);
        updateNodes(m, startingNode, startingNode, pathFilter);
    }


    static String getDirection(Position from, Position to) {
        if (from == to) {
            return "WRONG POSITIONS!";
        }

        if (from.row == to.row) {
            return from.col > to.col ? "LEFT" : "RIGHT";
        }
        else {
            return from.row > to.row ? "UP" : "DOWN";
        }
    }

    static List<Position> getNeighbours(Position pos, Function<Position, Boolean> filter) {
        List<Position> positions = new ArrayList<>();
        if (pos.row - 1 >= 0) {
            Position newPos = new Position(pos.row - 1, pos.col);
            if (filter.apply(newPos)) {
                positions.add(newPos);
            }
        }
        if (pos.row + 1 < R) {
            Position newPos = new Position(pos.row + 1, pos.col);
            if (filter.apply(newPos)) {
                positions.add(newPos);
            }
        }
        if (pos.col - 1 >= 0) {
            Position newPos = new Position(pos.row, pos.col - 1);
            if (filter.apply(newPos)) {
                positions.add(newPos);
            }
        }
        if (pos.col + 1 < C) {
            Position newPos = new Position(pos.row, pos.col + 1);
            if (filter.apply(newPos)) {
                positions.add(newPos);
            }
        }
        return positions;
    }

    private static void updateMaze(String row, int i, char[][] m) {
        for (int j = 0; j < row.length(); j++) {
            m[i][j] = row.charAt(j);
        }
    }

    static Node getNode(Position pos) {
        return nodes.stream().filter(n -> n.pos.equals(pos)).findFirst().get();
    }

    static List<Position> getMoves(Position me, Node controlRoom, Node startingNode, Status status, List path, Function<Position, Boolean> pathFilter, char[][] m) {

        // has arrived to the control room, and has only to go back to the starting point
        if (status == Status.GOING_TO_START) {
            List<Position> positions = breadthFirstSearch(getNode(me), startingNode);
            return positions;
        }
        // has discovered where the control room is, and heads there
        else if (status == Status.GOING_TO_CONTROL_ROOM) {
            List<Position> positions = breadthFirstSearch(getNode(me), controlRoom);
            return positions;
        }
        // doesn't know yet where the control room is, just wanders
        else {
            // FIXME: check a new one!
            List<Position> positions = getNeighbours(me, pathFilter);
            System.err.println("visited positions=" + visitedPositions);
            return positions.stream().filter( p -> !visitedPositions.contains(p)).collect(Collectors.toList());
        }
    }

    public static List<Position> breadthFirstSearch(Node startingNode, Node targetNode) {

//        System.err.println("STARTING BFS FROM " + startingNode + " TO " + targetNode);
        nodes.forEach(n -> n.status = Node.Status.UNKNOWN);
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(startingNode);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
//            System.err.println("BFS: polled " + currentNode.pos +" [" + currentNode.status + "] edges to: " + currentNode.nodes + " target=" + targetNode.pos);
            if (currentNode.equals(targetNode)) {
                List<Position> positions = new ArrayList<>();
                positions.add(targetNode.pos);
                while (currentNode.parent != null) {
                    positions.add(currentNode.parent.pos);
                    currentNode = currentNode.parent;
                }
                positions.remove(positions.size()-1);
                Collections.reverse(positions);
//                System.err.println("Path to target: " + positions);
                return positions;
            }
            currentNode.status = Node.Status.DISCOVERED;
            Node finalCurrentNode = currentNode;
            currentNode.nodes.stream()
                             .filter(connectedNode -> connectedNode.status == Node.Status.UNKNOWN)
                             .forEach(connectedNode -> {
//                                 System.err.println("adding node " + connectedNode.pos + " to queue");
                                 queue.add(connectedNode);
                                 connectedNode.status = Node.Status.DISCOVERED;
                                 connectedNode.parent = finalCurrentNode;
                             });
        }

        return null;
    }
}