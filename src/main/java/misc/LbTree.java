package misc;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LbTree {

    /**
     * You are given a binary tree in a peculiar string representation. Each node is written in the form (lr),
     * where l corresponds to the left child and r corresponds to the right child.
     *
     * If either l or r is null, it will be represented as a zero. Otherwise,
     * it will be represented by a new (lr) pair.
     *
     * Here are a few examples:
     *    A root node with no children: (00)
     *     A root node with two children: ((00)(00))
     *     An unbalanced tree with three consecutive left children: ((((00)0)0)0)
     *
     *  Given this representation, determine the depth of the tree.
     */

    @Test
    public void test() {
        assertEquals(1, getLbHeight("(00)"));
        assertEquals(2, getLbHeight("((00)(00))"));
        assertEquals(2, getLbHeight("((00)0)"));
        assertEquals(2, getLbHeight("(0(00))"));
        assertEquals(4, getLbHeight("((((00)0)0)0)"));
        assertEquals(4, getLbHeight("((00)(0(0(00))))"));
    }

    int getLbHeight(String tree) {

        int max = 0;
        int open = 0;

        for (int i=0; i<tree.length(); i++) {
            if (tree.charAt(i) == '(') {
                open ++;
                max = Math.max(max, open);
            }
            else if (tree.charAt(i) == ')') {
                open --;
            }
        }

        return max;
    }


}
