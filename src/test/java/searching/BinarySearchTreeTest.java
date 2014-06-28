package searching;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTreeTest {

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
}