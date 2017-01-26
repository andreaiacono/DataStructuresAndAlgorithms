package misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArithmeticExpression {

    @Test
    public void test() {

        Node root = new OperatorNode(Operator.PLUS);
        root.left = new OperandNode(3);
        root.left.parent = root;
        root.right = new OperatorNode(Operator.BY);
        root.right.parent = root;
        root.right.left = new OperatorNode(Operator.PLUS);
        root.right.left.parent = root.right;
        root.right.left.left = new OperandNode(5);
        root.right.left.left.parent = root.right.left;
        root.right.left.right = new OperandNode(9);
        root.right.left.right.parent = root.right.left;
        root.right.right = new OperandNode(2);
        root.right.right.parent = root.right;

        assertEquals(31, evaluate(root));
    }

    enum Operator {
        PLUS, MINUS, BY, DIVIDE;
    }

    abstract class Node {
        Node left;
        Node right;
        Node parent;
    }

    class OperatorNode extends Node {
        Operator operator;

        public OperatorNode(Operator operator) {
            this.operator = operator;
        }
    }

    class OperandNode extends Node {
        int val;

        public OperandNode(int val) {
            this.val = val;
        }
    }

    /**
     * this code assumes that the binary tree contains a correct expression.
     * @param node
     * @return
     */
    public int evaluate(Node node) {

        if (node instanceof OperandNode) {
            return ((OperandNode) node).val;
        }

        int valLeft = evaluate(node.left);
        int valRight = evaluate(node.right);

        switch (((OperatorNode) node).operator) {
            case PLUS:
                return valLeft + valRight;
            case MINUS:
                return valLeft - valRight;
            default: // the BY operation
                return valLeft * valRight;
        }
    }

}
