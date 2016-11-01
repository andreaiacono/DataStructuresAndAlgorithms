package misc;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.*;

public class CrackingCodeInterviewTest {
    @Test
    public void sortStack() throws Exception {

        Deque<Integer> stack = new ArrayDeque<>();
        CrackingCodeInterview.sortStack(stack);
        assertTrue(stack.isEmpty());

        stack = new ArrayDeque<>();
        stack.push(1);
        CrackingCodeInterview.sortStack(stack);
        assertEquals(new Integer(1), stack.pop());
        assertTrue(stack.isEmpty());

        stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        CrackingCodeInterview.sortStack(stack);
        assertEquals(new Integer(2), stack.pop());
        assertEquals(new Integer(1), stack.pop());
        assertTrue(stack.isEmpty());

        stack = new ArrayDeque<>();
        stack.push(2);
        stack.push(1);
        CrackingCodeInterview.sortStack(stack);
        assertEquals(new Integer(2), stack.pop());
        assertEquals(new Integer(1), stack.pop());
        assertTrue(stack.isEmpty());

        stack = new ArrayDeque<>();
        stack.push(3);
        stack.push(2);
        stack.push(5);
        CrackingCodeInterview.sortStack(stack);
        assertEquals(new Integer(5), stack.pop());
        assertEquals(new Integer(3), stack.pop());
        assertEquals(new Integer(2), stack.pop());
        assertTrue(stack.isEmpty());

        stack = new ArrayDeque<>();
        stack.push(2);
        stack.push(3);
        stack.push(5);
        CrackingCodeInterview.sortStack(stack);
        assertEquals(new Integer(5), stack.pop());
        assertEquals(new Integer(3), stack.pop());
        assertEquals(new Integer(2), stack.pop());
        assertTrue(stack.isEmpty());

        stack = new ArrayDeque<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        CrackingCodeInterview.sortStack(stack);
        assertEquals(new Integer(5), stack.pop());
        assertEquals(new Integer(4), stack.pop());
        assertEquals(new Integer(3), stack.pop());
        assertEquals(new Integer(2), stack.pop());
        assertEquals(new Integer(1), stack.pop());
        assertTrue(stack.isEmpty());
    }


    @Test
    public void runningUpStairs() throws Exception {

        assertEquals(4, CrackingCodeInterview.runningUpStairs(3));
        assertEquals(7, CrackingCodeInterview.runningUpStairs(4));
    }

    @Test
    public void robotPathsCount() throws Exception {

        assertEquals(4, CrackingCodeInterview.robotPaths(5, 5));
    }
}