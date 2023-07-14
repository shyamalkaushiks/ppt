class ListNode1 {
    int val;
    ListNode next;

    ListNode1(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Q2_RemoveDuplicate {
    public static ListNode removeDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode current = head;

        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example 1:
        ListNode head1 = new ListNode(11);
        head1.next = new ListNode(11);
        head1.next.next = new ListNode(11);
        head1.next.next.next = new ListNode(21);
        head1.next.next.next.next = new ListNode(43);
        head1.next.next.next.next.next = new ListNode(43);
        head1.next.next.next.next.next.next = new ListNode(60);

        System.out.println("Original List:");
        printLinkedList(head1);

        ListNode updatedHead1 = removeDuplicates(head1);

        System.out.println("List after removing duplicates:");
        printLinkedList(updatedHead1);

        System.out.println();

        // Example 2:
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(5);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next = new ListNode(7);

        System.out.println("Original List:");
        printLinkedList(head2);

        ListNode updatedHead2 = removeDuplicates(head2);

        System.out.println("List after removing duplicates:");
        printLinkedList(updatedHead2);
    }
}
