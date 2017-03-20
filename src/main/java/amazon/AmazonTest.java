package amazon;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 *
 */
public class AmazonTest {

    @Test
    public void test() {
        assertEquals(27,totalScore(new String[] {"5", "-2", "4", "Z", "X", "9", "+", "+"}, 8));
//        assertEquals(3,totalScore(new String[] {"1", "2", "+", "Z"}, 4));
        assertTrue(true);
    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int totalScore(String[] blocks, int n)
    {

        Deque<Integer> stack = new ArrayDeque<>();
        int total = 0;
        for (int i=0; i<n; i++) {
            String block = blocks[i];
            int last = stack.size() > 0 ? stack.peek() : 0;
            int secondLast = getSecond(stack);
            System.out.println("found " + block + " for tot =" + total +" stack=" + stack);
            if (block.equals("X")) {
                total += last * 2;
                stack.pop();
                stack.push(total);
            }
            else if (block.equals("Z")) {
                total -= last;
                stack.push(total);
                stack.pop();
            }
            else if (block.equals("+")) {
                total += last + secondLast;
                stack.push(total);
                stack.pop();
            }
            else {
                int num = Integer.parseInt(block);
                stack.push(num);
                total += num;
            }
            System.out.println("AFTER tot =" + total + " stack =" + stack + "\n");
        }

        return total;
    }

    private static int getSecond(Deque<Integer> stack) {

        if (stack.size() < 2) {
            return 0;
        }

        int top = stack.pop();
        int result = stack.pop();
        stack.push(result);
        stack.push(top);

        return result;
    }

}
