import java.util.Stack;

public class Q6_PostFixEvaluation {
    public static int evaluatePostfixExpression(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                int result = performOperation(operand1, operand2, c);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    public static int performOperation(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        String expression = "231*+9-";
        int result = evaluatePostfixExpression(expression);
        System.out.println(result);
    }
}
