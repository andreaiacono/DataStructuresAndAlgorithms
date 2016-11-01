package searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeTraversal {

    public static String stringify(Node node) {

        String result = "";
        for (Node child : node.children) {
            result += stringify(child);
        }
        result = "[" + node.key + (result.length() > 0 ? (result ) : "") + "]";
        return result;
    }
}

class Node {
    int key;
    List<Node> children = new ArrayList<>();

    public Node(int key) {
        this.key = key;
    }

    public void addChild(Node node) {
        children.add(node);
    }

    public void addChildren(Node... nodes) {
        children.addAll(Arrays.asList(nodes));
    }
}
