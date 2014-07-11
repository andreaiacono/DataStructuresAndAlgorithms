package datastructures;

import org.junit.Assert;
import org.junit.Test;

public class MyLinkedListTest {

    @Test
    public void testInsert() throws Exception {

        MyLinkedList<String> list = new MyLinkedList<>();
        Assert.assertTrue(list.size() == 0);

        list.add("test");
        Assert.assertTrue(list.size() == 1);

        String test = list.get(0);
        Assert.assertEquals("test", test);
    }

    @Test
    public void testInsertAt() throws Exception {

        MyLinkedList<String> list = new MyLinkedList<>();
        Assert.assertTrue(list.size() == 0);

        list.add("foo", 10);
        Assert.assertTrue(list.size() == 1);
        Assert.assertEquals("foo", list.get(10));
        Assert.assertEquals("foo", list.get(0));

        list.add("bar", 1);
        Assert.assertTrue(list.size() == 2);
        Assert.assertEquals("foo", list.get(0));
        Assert.assertEquals("bar", list.get(1));
        Assert.assertEquals("bar", list.get(12));

        list.add("test", 1);
        Assert.assertEquals("foo", list.get(0));
        Assert.assertEquals("test", list.get(1));
        Assert.assertEquals("bar", list.get(2));
        Assert.assertTrue(list.size() == 3);
    }

}