public class Q6_LeftShift {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode leftShift(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        int length = getLength(head);
        k = k % length; 

        if (k == 0) {
            return head; 
        }

        ListNode curr = head;
        ListNode newHead = null;
        ListNode newTail = null;
        ListNode prev = null;

        for (int i = 0; i < k; i++) {
            prev = curr;
            curr = curr.next;
        }

        newHead = curr;
        newTail = prev;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = head;

        newTail.next = null;

        return newHead;
    }

    private int getLength(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(8);
        ListNode node5 = new ListNode(9);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        int k = 3;

        Q6_LeftShift solution = new Q6_LeftShift();
        ListNode shiftedList = solution.leftShift(head, k);

        ListNode current = shiftedList;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
