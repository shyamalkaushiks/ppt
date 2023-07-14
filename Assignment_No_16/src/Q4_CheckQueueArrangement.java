import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q4_CheckQueueArrangement {
    public static String checkQueueArrangement(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> secondQueue = new LinkedList<>();

        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        int expectedElement = 1;

        while (!stack.isEmpty()) {
            int poppedElement = stack.pop();

            if (poppedElement == expectedElement) {
                secondQueue.offer(poppedElement);
                expectedElement++;
            } else {
                stack.push(poppedElement);
            }
        }

        if (secondQueue.isEmpty()) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue1 = new LinkedList<>();
        queue1.offer(5);
        queue1.offer(1);
        queue1.offer(2);
        queue1.offer(3);
        queue1.offer(4);
        System.out.println("Queue 1: " + queue1);
        String result1 = checkQueueArrangement(queue1);
        System.out.println("Result 1: " + result1);

        Queue<Integer> queue2 = new LinkedList<>();
        queue2.offer(5);
        queue2.offer(1);
        queue2.offer(2);
        queue2.offer(6);
        queue2.offer(3);
        queue2.offer(4);
        System.out.println("Queue 2: " + queue2);
        String result2 = checkQueueArrangement(queue2);
        System.out.println("Result 2: " + result2);
    }
}
