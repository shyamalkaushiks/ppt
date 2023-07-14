class ListNode6 {
    int val;
    ListNode next;

    ListNode6(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Q6_MergeSortedLinkList {
    public static ListNode mergeLists(ListNode a, ListNode b) {
        // Check if either of the lists is empty
        if (a == null)
            return b;
        if (b == null)
            return a;

        ListNode head;

        if (a.val <= b.val) {
            head = a;
            a = a.next;
        } else {
            head = b;
            b = b.next;
        }

        ListNode curr = head;

        // Merge the lists
        while (a != null && b != null) {
            if (a.val <= b.val) {
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }

        if (a != null)
            curr.next = a;
        else
            curr.next = b;

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
        ListNode a = new ListNode(5);
        a.next = new ListNode(10);
        a.next.next = new ListNode(15);

        ListNode b = new ListNode(2);
        b.next = new ListNode(3);
        b.next.next = new ListNode(20);

        System.out.println("List A:");
        printLinkedList(a);
        System.out.println("List B:");
        printLinkedList(b);

        ListNode mergedList = mergeLists(a, b);

        System.out.println("Merged List:");
        printLinkedList(mergedList);

        ListNode c = new ListNode(1);
        c.next = new ListNode(1);

        ListNode d = new ListNode(2);
        d.next = new ListNode(4);

        System.out.println("List C:");
        printLinkedList(c);
        System.out.println("List D:");
        printLinkedList(d);

        ListNode mergedList2 = mergeLists(c, d);

        System.out.println("Merged List:");
        printLinkedList(mergedList2);
    }
}
