package recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Tries {

    @Test
    public void test() {
        Node root = new Node(' ');
        Node p = new Node('p');
        Node a = new Node('a');
        Node n = new Node('n');
        Node d = new Node('d');
        Node a2 = new Node('a', true);
        Node i = new Node('i');
        Node g = new Node('g', true);
        Node e = new Node('e');
        Node o = new Node('o');
        Node n2 = new Node('n', true);
        root.children.add(p);
        p.children.add(a);
        a.children.add(n);
        n.children.add(d);
        d.children.add(a2);
        p.children.add(i);
        i.children.add(g);
        g.children.add(e);
        e.children.add(o);
        o.children.add(n2);

        System.out.println(getWords(root, new StringBuilder()));

//        assertThat(getWords(root, new StringBuilder()).size()).isEqual(3);
//        assertThat(getWords(root, new StringBuilder()).contains("panda")).isTrue();
//        assertThat(getWords(root, new StringBuilder()).contains("pig")).isTrue();
//        assertThat(getWords(root, new StringBuilder()).contains("pigeon")).isTrue();
    }

    List<String> getWords(Node current, StringBuilder partial) {

        StringBuilder appendedChar =  new StringBuilder(partial.toString() + current.c);

        if (current.children.size() == 0) {
            // asserts the trie is built correctly
            assert current.isComplete == true;
            return List.of(appendedChar.toString());
        }

        List<String> result = new ArrayList<>();
        for (Node child : current.children) {

            if (child.isComplete && child.children.size() > 0) {
                result.add(appendedChar.toString() + child.c);
            }
            result.addAll(getWords(child, appendedChar));
        }

        return result;

    }

    class Node {
        char c;
        List<Node> children = new ArrayList<>();
        boolean isComplete;

        public Node(char c) {
            this.c = c;
        }

        public Node(char c, boolean isComplete) {
            this(c);
            this.isComplete = isComplete;
        }

    }

}


