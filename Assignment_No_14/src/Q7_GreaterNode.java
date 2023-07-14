import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Q7_GreaterNode {
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();
        ListNode curr = head;

        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        int[] result = new int[list.size()];
        Stack<Integer> stack = new Stack<>();

        for (int i = list.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && list.get(i) >= stack.peek()) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek();
            }

            stack.push(list.get(i));
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(5);

        head.next = node2;
        node2.next = node3;

        Q7_GreaterNode solution = new Q7_GreaterNode();
        int[] result = solution.nextLargerNodes(head);

        System.out.println(Arrays.toString(result));
    }
}
