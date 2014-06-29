package searching;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTreeTest {

    private BinarySearchTree tree;

    @Before
    public void setUp() throws Exception {
        tree = new BinarySearchTree();
        tree.insert(8, "8");
        tree.insert(3, "3");
        tree.insert(1, "1");
        tree.insert(6, "6");
        tree.insert(4, "4");
        tree.insert(7, "7");
        tree.insert(10, "10");
        tree.insert(14, "14");
        tree.insert(13, "13");
    }

    @org.junit.Test
    public void testCreate() throws Exception {

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        assertEquals(binarySearchTree.getValue(1), null);

    }

    @Test
    public void testInsert() throws Exception {

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        assertEquals(binarySearchTree.getValue(1), null);

        binarySearchTree.insert(10, "ten");
        assertEquals(binarySearchTree.getValue(10), "ten");

        binarySearchTree.insert(20, "twenty");
        assertEquals(binarySearchTree.getValue(20), "twenty");

        binarySearchTree.insert(5, "five");
        assertEquals(binarySearchTree.getValue(5), "five");

        binarySearchTree.insert(50, "fifty");
        assertEquals(binarySearchTree.getValue(50), "fifty");

        assertEquals(binarySearchTree.getValue(1000), null);

    }

    @Test
    public void testTraversal() throws Exception {

        StringBuilder builder = new StringBuilder();
        tree.preOrderRecursiveTraversal(tree.getRoot(), builder);
        System.out.println("Tree rec preorder: " + builder.toString());

        builder = new StringBuilder();
        tree.preOrderTraversal(builder);
        System.out.println("Tree     preorder: " + builder.toString());

        builder = new StringBuilder();
        tree.inOrderRecursiveTraversal(tree.getRoot(), builder);
        System.out.println("Tree rec inorder: " + builder.toString());

        builder = new StringBuilder();
        tree.inOrderTraversal(builder);
        System.out.println("Tree     inorder: " + builder.toString());

        builder = new StringBuilder();
        tree.postOrderRecursiveTraversal(tree.getRoot(), builder);
        System.out.println("Tree rec postord: " + builder.toString());


    }

    @Test
    public void testInOrderTraversal() throws Exception {




    }
}