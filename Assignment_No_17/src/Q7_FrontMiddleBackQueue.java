import java.util.LinkedList;
import java.util.Queue;

class FrontMiddleBackQueue {
    private Queue<Integer> frontQueue;
    private Queue<Integer> backQueue;

    public FrontMiddleBackQueue() {
        frontQueue = new LinkedList<>();
        backQueue = new LinkedList<>();
    }

    public void pushFront(int val) {
        frontQueue.offer(val);
        balanceQueues();
    }

    public void pushMiddle(int val) {
        if (frontQueue.size() > backQueue.size()) {
            backQueue.offer(frontQueue.poll());
        }
        frontQueue.offer(val);
    }

    public void pushBack(int val) {
        backQueue.offer(val);
        balanceQueues();
    }

    public int popFront() {
        if (isEmpty()) {
            return -1;
        }
        if (!frontQueue.isEmpty()) {
            return frontQueue.poll();
        } else {
            int frontVal = backQueue.poll();
            balanceQueues();
            return frontVal;
        }
    }

    public int popMiddle() {
        if (isEmpty()) {
            return -1;
        }
        int middleVal = frontQueue.poll();
        balanceQueues();
        return middleVal;
    }

    public int popBack() {
        if (isEmpty()) {
            return -1;
        }
        if (!backQueue.isEmpty()) {
            return backQueue.poll();
        } else {
            int backVal = frontQueue.poll();
            balanceQueues();
            return backVal;
        }
    }

    private void balanceQueues() {
        if (frontQueue.size() > backQueue.size() + 1) {
            backQueue.offer(frontQueue.poll());
        } else if (frontQueue.size() < backQueue.size()) {
            frontQueue.offer(backQueue.poll());
        }
    }

    private boolean isEmpty() {
        return frontQueue.isEmpty() && backQueue.isEmpty();
    }
}

public class Q7_FrontMiddleBackQueue {
    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);   // [1]
        q.pushBack(2);    // [1,2]
        q.pushMiddle(3);  // [1,3,2]
        q.pushMiddle(4);  // [1,4,3,2]
        System.out.println(q.popFront());     // Output: 1 -> [4,3,2]
        System.out.println(q.popMiddle());    // Output: 3 -> [4,2]
        System.out.println(q.popMiddle());    // Output: 4 -> [2]
        System.out.println(q.popBack());      // Output: 2 -> []
        System.out.println(q.popFront());     // Output: -1 -> [] (The queue is empty)
    }
}
