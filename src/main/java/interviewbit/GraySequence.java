package interviewbit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GraySequence {

    @Test
    public void test() {
        System.out.println((grayCode(3)));
    }

    ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> values = new ArrayList<>();
        values.add(0);
        values.add(1);

        for (int i = 1; i < n; i++) {
            List<Integer> valuesToAdd = new ArrayList<>();
            for (int j=values.size()-1; j>=0; j--) {
                valuesToAdd.add(values.get(j) | 1 << i);
            }
            values.addAll(valuesToAdd);
        }
        return values;
    }
}
    /*

    runtime complexity too high

    ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> values = new ArrayList<>();
        values.add(0);
        return grayCode(n, values);
    }

    ArrayList<Integer> grayCode(int n, ArrayList<Integer> values) {

        if (values.size() == (int) Math.pow(2, n)) {
            return values;
        }


        int last = values.get(values.size()-1);
        for (Integer next: getFollowingNumbers(last, n)) {
            if (!values.contains(next)) {
                values.add(next);
                if (grayCode(n, values) != null) {
                    return values;
                }
                values.remove(next);
            }
        }


        return null;
    }


    List<Integer> getFollowingNumbers(int value, int n) {

        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int following = value ^ (1 << i);
            values.add(following);
        }
        return values;
    }
*/






    /*

    WORKING BUT TOO MEMORY CONSUMING

    class Node {
        int value;
        int level;
        List<Integer> visited;

        Node parent;

        public Node(int value, Node parent, int level, List<Integer> visited) {
            this.value = value;
            this.parent = parent;
            this.level = level;
            this.visited = new ArrayList<>(visited);
            this.visited.add(value);
        }

    }


    ArrayList<Integer> grayCode(int n) {
        Node start = new Node(0, null, 1, new ArrayList<>());
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(start);
        int levelSearched = (int) Math.pow(2, n);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (current.visited.size() == levelSearched) {
                return getPath(current);
            }
            for (int code : getFollowingNumbers(current.value, n)) {
                Node child = new Node(code, current, current.level + 1, current.visited);
                if (!current.visited.contains(code)) {
                    stack.push(child);
                }
            }
        }

        return null;
    }


    List<Integer> getFollowingNumbers(int value, int n) {
        List<Integer> values = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int following = value ^ (1 << i);
            values.add(following);
        }
        return values;
    }


    ArrayList<Integer> getPath(Node node) {
        ArrayList<Integer> path = new ArrayList<>();
        while (node != null) {
            path.add(node.value);
            node = node.parent;
        }
        return path;
    }

    List<String> toString(List<Integer> vals) {
        return vals.stream().map(v -> Integer.toBinaryString(v)).collect(Collectors.toList());
    }
    */
