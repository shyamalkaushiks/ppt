class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Q1_MergeLinkedList {
    public static ListNode mergeLists(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val >= head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }

        if (head1 != null)
            curr.next = head1;
        if (head2 != null)
            curr.next = head2;

        return dummy.next;
    }

    public static void main(String[] args) {
        // Test case 1:
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);

        ListNode mergedList = mergeLists(head1, head2);

        System.out.print("Merged List: ");
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
        System.out.println();

        // Test case 2:
        ListNode head3 = new ListNode(7);
        head3.next = new ListNode(9);
        head3.next.next = new ListNode(11);

        ListNode head4 = new ListNode(8);
        head4.next = new ListNode(10);
        head4.next.next = new ListNode(12);

        ListNode mergedList2 = mergeLists(head3, head4);

        System.out.print("Merged List: ");
        while (mergedList2 != null) {
            System.out.print(mergedList2.val + " ");
            mergedList2 = mergedList2.next;
        }
        System.out.println();
    }
}
