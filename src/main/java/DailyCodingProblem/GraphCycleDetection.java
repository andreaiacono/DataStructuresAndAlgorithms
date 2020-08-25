package DailyCodingProblem;

import java.util.ArrayList;
import java.util.List;

public class GraphCycleDetection {


    public static void main(String[] args) {

    }

    boolean hasCycle(Node root) {
        root.visited = true;
        for (Node neighbor: root.neighbors) {
            if (!neighbor.visited) {
                hasCycle(neighbor);
            }
            else {
                return true;
            }
        }
        return false;
    }



    class Node {
        int value;
        boolean visited;
        List<Node> neighbors = new ArrayList<>();
        public Node(int value) {
            this.value = value;
        }
    }
}
