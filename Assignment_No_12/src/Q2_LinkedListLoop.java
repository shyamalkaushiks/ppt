class ListNode1 {
    int val;
    ListNode next;

    ListNode1(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Q2_LinkedListLoop {
    public static boolean hasLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // Loop detected
            }
        }

        return false; // No loop detected
    }

    public static void main(String[] args) {
        // Create a linked list with a loop: 1 -> 2 -> 3 -> 4 -> 5 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next.next; // Creating a loop

        boolean hasLoop = hasLoop(head);
        System.out.println("Has Loop: " + hasLoop);
    }
}
