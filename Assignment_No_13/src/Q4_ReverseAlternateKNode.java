class ListNode4 {
    int val;
    ListNode next;

    ListNode4(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Q4_ReverseAlternateKNode {
    public static ListNode reverseAlternateKNodes(ListNode head, int k) {
        if (head == null || k <= 1)
            return head;

        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        int count = 0;

        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (head != null)
            head.next = current;

        count = 0;
        while (count < k - 1 && current != null) {
            current = current.next;
            count++;
        }

        if (current != null)
            current.next = reverseAlternateKNodes(current.next, k);

        return prev;
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
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);

        System.out.println("Original List:");
        printLinkedList(head);

        int k = 3;
        ListNode updatedHead = reverseAlternateKNodes(head, k);

        System.out.println("List after reversing every alternate " + k + " nodes:");
        printLinkedList(updatedHead);
    }
}
