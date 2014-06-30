package datastructures;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {

    BinaryTree tree = new BinaryTree();


    @Before
    public void setUp() throws Exception {

        BinaryTree.Node node = tree.insert(10, "10", null);
        BinaryTree.Node node15 = tree.insert(15,"15", node);
        BinaryTree.Node node25 = tree.insert(25,"25", node);
        tree.insert(5,"5", node15);
        tree.insert(23, "23", node15);
        tree.insert(46,"46", node25);
        node = tree.insert(4,"4", node25);
        tree.insert(11,"11", node);
        tree.insert(461,"461", node);
    }

    @Test
    public void testFindNode() throws Exception {

        Assert.assertEquals("23", tree.getValue(23));
    }

    @Test
    public void testGetHeight() throws Exception {

        Assert.assertEquals(4, tree.getHeight());
    }

    @Test
    public void testInsert() throws Exception {

        BinaryTree.Node root = tree.getRoot();
        Assert.assertEquals("10", root.getValue());
        Assert.assertEquals("15", root.getLeft().getValue());
        Assert.assertEquals("25", root.getRight().getValue());
        Assert.assertEquals(root.getRight(), tree.getNode(root, 25));
        Assert.assertEquals("5", tree.getNode(root, 5).getValue());
        Assert.assertEquals(root.getLeft().getLeft(), tree.getNode(root, 5));
        Assert.assertEquals(root.getLeft().getRight(), tree.getNode(root, 23));
        Assert.assertEquals(root.getRight().getLeft(), tree.getNode(root, 46));
        Assert.assertEquals(root.getRight().getRight(), tree.getNode(root, 4));
        Assert.assertEquals(root.getRight().getRight().getLeft(), tree.getNode(root, 11));
        Assert.assertEquals(root.getRight().getRight().getRight(), tree.getNode(root, 461));
    }

    @Test
    public void testRecursiveTraversal() throws Exception {

        StringBuilder builder = new StringBuilder();
        tree.recursiveTraversal(BinaryTree.TraversalType.PREORDER, tree.getRoot(), builder);
        Assert.assertEquals("10 15 5 23 25 46 4 11 461 ", builder.toString());

        builder = new StringBuilder();
        tree.recursiveTraversal(BinaryTree.TraversalType.INORDER, tree.getRoot(), builder);
        Assert.assertEquals("5 15 23 10 46 25 11 4 461 ", builder.toString());

        builder = new StringBuilder();
        tree.recursiveTraversal(BinaryTree.TraversalType.POSTORDER, tree.getRoot(), builder);
        Assert.assertEquals("5 23 15 46 11 461 4 25 10 ", builder.toString());
    }

    @Test
    public void testLevelOrderTraversal() throws Exception {

        StringBuilder builder = new StringBuilder();
        tree.levelOrderTraversal(builder);
        Assert.assertEquals("10 15 25 5 23 46 4 11 461 ", builder.toString());
    }
}