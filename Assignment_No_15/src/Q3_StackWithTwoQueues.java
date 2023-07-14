import java.util.LinkedList;
import java.util.Queue;

public class Q3_StackWithTwoQueues {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public Q3_StackWithTwoQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int value) {
        q1.add(value);
    }

    public int pop() {
        if (q1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int poppedElement = q1.remove();

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return poppedElement;
    }

    public static void main(String[] args) {
        Q3_StackWithTwoQueues stack = new Q3_StackWithTwoQueues();

        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); // Output: 3

        stack.push(4);
        System.out.println(stack.pop()); // Output: 4
    }
}
