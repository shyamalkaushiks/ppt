class ListNode7 {
    int val;
    ListNode next;

    ListNode7(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Q7_insrtAlternate {
    public static ListNode insertAlternate(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2; // If the first list is empty, return the second list
        }
        if (head2 == null) {
            return head1; // If the second list is empty, return the first list
        }

        ListNode current1 = head1;
        ListNode current2 = head2;

        while (current1 != null && current2 != null) {
            ListNode next1 = current1.next; // Store the next node of current1
            ListNode next2 = current2.next; // Store the next node of current2

            current1.next = current2; // Make current2 the next node of current1

            if (next1 != null) {
                current2.next = next1; // Make next1 the next node of current2 if it exists
            }

            current1 = next1; // Move current1 to the next node
            current2 = next2; // Move current2 to the next node
        }

        // If there are remaining nodes in the second list, append them to the end of the first list
        if (current1 == null && current2 != null) {
            ListNode lastNode = getLastNode(head1);
            lastNode.next = current2;
        }

        return head1;
    }

    public static ListNode getLastNode(ListNode head) {
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Test case
        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(7);
        head1.next.next = new ListNode(17);
        head1.next.next.next = new ListNode(13);
        head1.next.next.next.next = new ListNode(11);

        ListNode head2 = new ListNode(12);
        head2.next = new ListNode(10);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(6);

        System.out.println("First List:");
        printList(head1);

        System.out.println("Second List:");
        printList(head2);

        ListNode result = insertAlternate(head1, head2);

        System.out.println("Modified First List:");
        printList(result);

        System.out.println("Modified Second List:");
        printList(head2);
    }
}
