class ListNode3 {
    int val;
    ListNode next;

    ListNode3(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Q3_ReverseKNode {
    public static ListNode reverseKNodes(ListNode head, int k) {
        if (head == null || k == 1)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        int count = 0;
        while (curr != null) {
            count++;

            if (count % k == 0) {
                prev = reverseGroup(prev, curr.next);
                curr = prev.next;
            } else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }

    private static ListNode reverseGroup(ListNode prev, ListNode next) {
        ListNode curr = prev.next;
        ListNode tail = curr;

        ListNode prevNode = prev;
        ListNode nextNode;

        while (curr != next) {
            nextNode = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = nextNode;
        }

        prev.next = prevNode;
        tail.next = curr;

        return tail;
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
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        System.out.println("Original List:");
        printLinkedList(head);

        int k = 4;
        ListNode updatedHead = reverseKNodes(head, k);

        System.out.println("List after reversing every " + k + " nodes:");
        printLinkedList(updatedHead);
    }
}
