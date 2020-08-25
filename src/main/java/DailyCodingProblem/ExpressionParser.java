package DailyCodingProblem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class ExpressionParser {

    static Set<Character> operators = new HashSet<>();

    public static void main(String[] args) {
        operators.add('+');
        operators.add('*');
        operators.add('-');
        operators.add('/');
        String expr = "5 * (2 + 3)";
        int result = eval(expr);
        assert result == 4;
    }

    static int eval(String expr) {
        expr = expr.replaceAll(" ", "");
        Deque<String> parenthesis = new ArrayDeque<>();
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '(') {
                int result = eval(expr.substring(i));
            } else if (expr.charAt(i) == ')') {

            } else if (operators.contains(expr.charAt(i))) {

            }
        }

        return 0;
    }

}
