package searching;

import datastructures.node.BasicNode;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void testGetNode() throws Exception {

        BasicNode[] nodes = {new BasicNode(5, "5"), new BasicNode(12, "12"),new BasicNode(15, "15"),new BasicNode(21, "21"),new BasicNode(36, "36"),new BasicNode(40, "40")};

        BasicNode result = BinarySearch.getNode(nodes, 15);
        Assert.assertNotNull(result);
        Assert.assertEquals("15",result.getValue());

        result = BinarySearch.getNode(nodes, 34412);
        Assert.assertNull(result);
    }
}