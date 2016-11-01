package datastructures;

import org.junit.Assert;
import org.junit.Test;

public class ArrayStackTest {
    @Test
    public void testPushPop() throws Exception {

        ArrayStack<String> stack = new ArrayStack<>();

        Assert.assertNull(stack.pop());
        stack.push("contains");
        Assert.assertEquals("contains", stack.pop());
        Assert.assertNull(stack.pop());

        stack.push("foo");
        stack.push("bar");
        Assert.assertEquals("bar", stack.pop());
        Assert.assertEquals("foo", stack.pop());
        Assert.assertNull(stack.pop());

        stack.push("foo");
        stack.push("bar");
        Assert.assertEquals("bar", stack.pop());
        stack.push("contains");
        Assert.assertEquals("contains", stack.pop());
        Assert.assertEquals("foo", stack.pop());
        Assert.assertNull(stack.pop());
    }
}