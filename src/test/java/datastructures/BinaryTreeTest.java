package datastructures;


import org.junit.Assert;
import org.junit.Test;

import static datastructures.BinaryTree.*;
import static org.junit.Assert.*;

public class BinaryTreeTest {

    @Test
    public void testFindNode() throws Exception {

        Integer a = new Integer(2347234);
        Integer b = new Integer(2347234);
        Assert.assertEquals(a, b);
        Assert.assertEquals(true, a==b);


        BinaryTree tree = new BinaryTree();

        BinaryTree.Node root = tree.insert(10, "10", null);
        BinaryTree.Node node = tree.insert(15,"15", root);
        node = tree.insert(25,"25", node);
        node = tree.insert(5,"5", node);
        node = tree.insert(23,"23", node);
        node = tree.insert(46,"46", node);
        node = tree.insert(4,"4", node);
        node = tree.insert(11,"11", node);
        node = tree.insert(461,"461", node);

        Assert.assertEquals("23", tree.getValue(23));

    }
}