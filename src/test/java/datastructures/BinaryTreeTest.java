package datastructures;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static datastructures.BinaryTree.*;
import static org.junit.Assert.*;

public class BinaryTreeTest {

    BinaryTree tree = new BinaryTree();


    @Before
    public void setUp() throws Exception {

        BinaryTree.Node node = tree.insert(10, "10", null);
        tree.insert(15,"15", node);
        node = tree.insert(25,"25", node);
        tree.insert(5,"5", node);
        node = tree.insert(23,"23", node);
        tree.insert(46,"46", node);
        node = tree.insert(4,"4", node);
        tree.insert(11,"11", node);
        tree.insert(461,"461", node);

        StringBuilder builder = new StringBuilder();
        tree.recursiveTraversal(TraversalType.INORDER, tree.getRoot(), builder);
        System.out.println(builder.toString());
    }

    @Test
    public void testFindNode() throws Exception {

        Assert.assertEquals("23", tree.getValue(23));
    }

    @Test
    public void testGetHeight() throws Exception {

        Assert.assertEquals(3, tree.getHeight());
    }
}