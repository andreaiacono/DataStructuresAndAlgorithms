package datastructures;

import org.junit.Assert;
import org.junit.Test;

public class SortedLinkedListTest {

    @Test
    public void testSize() throws Exception {

        SortedLinkedList list = new SortedLinkedList();
        Assert.assertEquals(0, list.getSize());

        list.insert(10);
        Assert.assertEquals(1, list.getSize());

        list.insert(5);
        Assert.assertEquals(2, list.getSize());

        list.insert(20);
        Assert.assertEquals(3, list.getSize());
    }
}