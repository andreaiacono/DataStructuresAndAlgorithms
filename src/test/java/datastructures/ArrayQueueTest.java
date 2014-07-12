package datastructures;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayQueueTest {

    @Test
    public void testPushPop() throws Exception {

        ArrayQueue<String> queue = new ArrayQueue<>();
        Assert.assertNull(queue.pop());
        queue.push("test");
        Assert.assertEquals("test", queue.pop());
        Assert.assertNull(queue.pop());

        queue.push("foo");
        queue.push("bar");
        Assert.assertEquals("foo", queue.pop());
        Assert.assertEquals("bar", queue.pop());
        Assert.assertNull(queue.pop());


        queue.push("foo");
        queue.push("bar");
        Assert.assertEquals("foo", queue.pop());
        queue.push("test");
        Assert.assertEquals("bar", queue.pop());
        Assert.assertEquals("test", queue.pop());
        Assert.assertNull(queue.pop());
    }
}