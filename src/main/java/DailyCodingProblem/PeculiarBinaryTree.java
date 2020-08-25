package DailyCodingProblem;

import java.util.*;

public class PeculiarBinaryTree {

    /**
     * You are given a binary tree in a peculiar string representation. Each node is written in the form (lr),
     * where l corresponds to the left child and r corresponds to the right child.
     * <p>
     * If either l or r is null, it will be represented as a zero. Otherwise, it will be represented by a new (lr) pair.
     * <p>
     * Here are a few examples:
     * <p>
     * A root node with no children: (00)
     * A root node with two children: ((00)(00))
     * An unbalanced tree with three consecutive left children: ((((00)0)0)0)
     * <p>
     * Given this representation, determine the depth of the tree.
     */

    public static void main(String[] args) {
        List<String> vals = List.of("(00)", "((((00)0)0)0)", "(((00)0)(0(00)))");
        vals.stream().
                map(it -> it.substring(1, it.length() - 1)).
                forEach(it -> System.out.println("Depth of " + it + ": " + depth(it) + "\n"));
    }

    private static Pair depth(String s) {
        System.out.println("Calling with " + s);
        if (s.length() == 2) {
            return new Pair(0, 0);
        }

        int left = 0;
        if (s.charAt(0) != '0') {
            Pair child = depth(s.substring(1, s.indexOf(")")));
            left = child.left + 1;
        }
        int right = 0;
        if (s.charAt(s.length() - 1) != '0') {
            String rightChild = s.substring(s.indexOf("(", s.indexOf(")") + 1));
            Pair child = depth(rightChild);
            right = child.right + 1;
        }
        return new Pair(left, right);
    }

    static class Pair {
        int left;
        int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "(" + left + ", " + right + ")";
        }
    }
}
