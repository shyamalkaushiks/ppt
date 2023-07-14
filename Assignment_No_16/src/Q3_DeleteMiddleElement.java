import java.util.Stack;

public class Q3_DeleteMiddleElement {
    public static void deleteMiddle(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int midIndex = stack.size() / 2;
        deleteMiddle(stack, midIndex);
    }

    private static void deleteMiddle(Stack<Integer> stack, int currentIndex) {
        if (currentIndex == 0) {
            stack.pop();
            return;
        }

        int temp = stack.pop();
        deleteMiddle(stack, currentIndex - 1);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        System.out.println("Original Stack 1: " + stack1);
        deleteMiddle(stack1);
        System.out.println("Modified Stack 1: " + stack1);

        Stack<Integer> stack2 = new Stack<>();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(4);
        stack2.push(5);
        stack2.push(6);
        System.out.println("Original Stack 2: " + stack2);
        deleteMiddle(stack2);
        System.out.println("Modified Stack 2: " + stack2);
    }
}
