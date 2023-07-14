class ListNode5 {
    int val;
    ListNode next;

    ListNode5(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Q5_RemoveLoopLinkedList {
    public static ListNode detectAndRemoveLoop(ListNode head) {
        if (head == null || head.next == null) {
            return head; // No loop in the list
        }

        ListNode slow = head;
        ListNode fast = head;

        // Detect the loop using Floyd's cycle-finding algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break; // Loop detected
            }
        }

        // If there is no loop, return the head of the list
        if (slow != fast) {
            return head;
        }

        // Move slow back to the head and find the loop start node
        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the loop by setting the next pointer of the loop start node to null
        fast.next = null;

        return head;
    }

    public static void main(String[] args) {
        // Create a linked list with a loop: 1 -> 3 -> 4 -> 2 (loop start node)
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = head.next; // Creating a loop

        ListNode result = detectAndRemoveLoop(head);

        if (result == null) {
            System.out.println("No loop in the linked list");
        } else {
            System.out.println("Loop removed, new linked list:");
            ListNode current = result;
            while (current != null) {
                System.out.print(current.val + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }
}
