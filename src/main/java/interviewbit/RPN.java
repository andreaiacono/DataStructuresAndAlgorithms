package interviewbit;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class RPN {

    @Test
    public void test() {
        List<String> input = Arrays.asList( "2", "2", "/" );
        ArrayList<String> i = new ArrayList<>(input);
        assertEquals(1, evalRPN(i));

        input = Arrays.asList( "2", "1", "+", "3", "*" );
        i = new ArrayList<>(input);
        assertEquals(9, evalRPN(i));

        input = Arrays.asList( "4", "13", "5", "/", "+");
        i = new ArrayList<>(input);
        assertEquals(6, evalRPN(i));
    }

    public int evalRPN(ArrayList<String> a) {

        Set<String> operators = new HashSet<String>() {{
            add("+");
            add("-");
            add("*");
            add("/");
        }};
        Deque<Integer> stack = new ArrayDeque<>();

        for (String op: a) {
            if (operators.contains(op)) {
                Integer op2 = stack.pop();
                Integer op1 = stack.pop();
                Integer result = execute(op1, op2, op);
                stack.push(result);
            }
            else {
                stack.push(Integer.parseInt(op));
            }
        }

        return stack.pop();
    }

    Integer execute(Integer op1, Integer op2, String op) {
        Integer result = null;
        switch (op) {
            case "+":
                result = op1 + op2;
                break;
            case "-":
                result = op1 - op2;
                break;
            case "*":
                result = op1 * op2;
                break;
            case "/":
                result = op1 / op2;
                break;
            default:
                result = -1;
        }

        return result;
    }
}
