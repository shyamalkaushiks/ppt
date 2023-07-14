class ListNode5 {
    int val;
    ListNode next;

    ListNode5(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Q5_DeleteLastNode {
    public static ListNode deleteLastOccurrence(ListNode head, int key) {
        if (head == null)
            return null;

        ListNode prev = null;
        ListNode last = null;
        ListNode current = head;
        ListNode toDelete = null;

        while (current != null) {
            if (current.val == key)
                last = prev;

            prev = current;
            current = current.next;
        }

        if (last != null)
            toDelete = last.next;

        if (toDelete != null) {
            last.next = toDelete.next;
            toDelete.next = null;
        }

        if (head.val == key)
            head = head.next;

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
        // Example:
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(10);

        System.out.println("Original List:");
        printLinkedList(head);

        int key = 2;
        ListNode updatedHead = deleteLastOccurrence(head, key);

        System.out.println("List after deleting the last occurrence of key " + key + ":");
        printLinkedList(updatedHead);
    }
}
