package datastructures;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Trie {

    Node root = new Node((char)0);

    public void addWord(String word) {

        if (isPresent(word)) {
            return;
        }

        Node node = root;
        int index=0;
        while (index < word.length()) {
            if (!node.contains(word.charAt(index))) {
                break;
            }
            node = node.getChild(word.charAt(index));
            index++;
        }

        while (index < word.length()) {
            node = node.addChild(new Node(word.charAt(index++)));
        }
        node.setTerminal(true);
    }

    public boolean isPresent(String word) {
        Node node = root;
        for (int j=0; j<word.length(); j++) {
            if (!node.contains(word.charAt(j))) {
                return false;
            }
            node = node.getChild(word.charAt(j));
        }
        return node.isLastLetter();
    }

    public Node findPrefix(String word) {
        Node result = null;
        boolean setAsLast = true;
        Node node = root;
        for (int j=0; j<word.length(); j++) {
            if (!node.contains(word.charAt(j))) {
                return null;
            }
            if (setAsLast) {
                result = node;
                setAsLast = false;
            }
            if (node.children.size() > 1) {
                setAsLast = true;
            }
            node = node.getChild(word.charAt(j));
        }

        return result;
    }


    static class Node {
        char c;
        boolean isTerminal;
        Set<Node> children = new HashSet<>();

        public Node(char c) {
            this.c = c;
        }

        public void setTerminal(boolean terminal) {
            isTerminal = terminal;
        }

        public boolean contains(char c) {
            return getChild(c) != null;
        }

        public Node getChild(char c) {
            Iterator<Node> nodes = children.iterator();
            while (nodes.hasNext()) {
                Node node = nodes.next();
                if (node.c == c) {
                    return node;
                }
            }
            return null;
        }

        public Node addChild(Node node) {
            children.add(node);
            return node;
        }

        public boolean isLastLetter() {
            return isTerminal;
        }

        @Override
        public String toString() {
            return c + " - " + children;
        }
    }
}
