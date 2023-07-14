import java.util.Stack;

public class Q7_MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public Q7_MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int val = stack.pop();

        if (val == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Q7_MinStack minStack = new Q7_MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println(minStack.getMin()); // Output: -3

        minStack.pop();

        System.out.println(minStack.top());    // Output: 0

        System.out.println(minStack.getMin()); // Output: -2
    }
}
