package interviewbit;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertEquals;

/**
 * https://www.interviewbit.com/problems/reverse-integer/
 */
public class ReverseNumber {

    @Test
    public void test() {
        assertEquals(0, reverse(-1146467285));
    }

    public int reverse(int a) {

        boolean isNegative = a < 0 ? true : false;
        if (isNegative) {
            a = -a;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        while (a > 0) {
            stack.push(a % 10);
            a /= 10;
        }

        long result = 0;
        int index = 0;
        while (!stack.isEmpty()) {
            if (index >= 10) {
                return 0;
            }
            long pow = (int) Math.pow(10, index++);
            long val = stack.pop();
            if (result + (pow * val) > Integer.MAX_VALUE) {
                return 0;
            }
            result += pow * val;
        }

        if (isNegative) {
            return (int) -result;
        }

        return (int) result;
    }
}
