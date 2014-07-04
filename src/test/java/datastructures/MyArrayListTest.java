package datastructures;

import org.junit.Assert;
import org.junit.Test;

public class MyArrayListTest {

    @Test
    public void testCreation() throws Exception {

        MyArrayList<String> list = new MyArrayList<>();
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testInsert() throws Exception {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("foo");
        Assert.assertEquals(1, list.size());
        Assert.assertEquals("foo", list.get(0));

        list = new MyArrayList<>(1);
        list.add("foo");
        try {
            list.add("bar");
            Assert.fail();
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testRemove() throws Exception {

        MyArrayList<String> list = new MyArrayList<>();
        try {
            list.remove(0);
            Assert.fail();
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            Assert.assertTrue(true);
        }

        list.add("foo");
        Assert.assertEquals("foo", list.remove(0));
        Assert.assertEquals(0, list.size());

        try {
            list.remove(0);
            Assert.fail();
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            Assert.assertTrue(true);
        }
    }
}