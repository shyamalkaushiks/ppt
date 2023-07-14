class ListNode8 {
    int val;
    ListNode next;

    ListNode8(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Q8_CircularLinkedLList {
    public static boolean isCircular(ListNode head) {
        if (head == null)
            return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast)
                return true;

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    public static void main(String[] args) {
        // Test case 1: Circular linked list
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = head1; // Point the last node to the head

        System.out.println(isCircular(head1)); // Output: true

        // Test case 2: Non-circular linked list
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);

        System.out.println(isCircular(head2)); // Output: false
    }
}
