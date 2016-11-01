package recursion;

import datastructures.BinaryTree;
import datastructures.node.BinaryTreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeAlgoTest {

    @Test
    public void treeSum() {

        BinaryTree tree = new BinaryTree();

        BinaryTreeNode node = tree.insert(10, "10", null);
        BinaryTreeNode node15 = tree.insert(15,"15", node);
        BinaryTreeNode node25 = tree.insert(25,"25", node);
        tree.insert(5,"5", node15);
        tree.insert(23, "23", node15);
        tree.insert(46,"46", node25);
        node = tree.insert(4,"4", node25);
        tree.insert(11,"11", node);
        tree.insert(461,"461", node);

        assertEquals(600, TreeAlgo.treeSum(tree));
    }


}