class ListNode6 {
    int val;
    ListNode next;

    ListNode6(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Q6_RetainDeleteLinkedList {
    public static ListNode retainAndDelete(ListNode head, int M, int N) {
        if (head == null || M <= 0 || N <= 0) {
            return head; 
        }

        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            for (int i = 0; i < M; i++) {
                if (current == null) {
                    return head; 
                }
                previous = current;
                current = current.next;
            }

            for (int i = 0; i < N; i++) {
                if (current == null) {
                    break; 
                }
                current = current.next;
            }

            previous.next = current;
        }

        return head;
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
        // Test case 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);
        head1.next.next.next.next.next.next.next = new ListNode(8);
        int M1 = 2;
        int N1 = 2;

        System.out.println("Original Linked List:");
        printList(head1);

        ListNode result1 = retainAndDelete(head1, M1, N1);

        System.out.println("Modified Linked List:");
        printList(result1);

        System.out.println();

        // Test case 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next = new ListNode(6);
        head2.next.next.next.next.next.next = new ListNode(7);
        head2.next.next.next.next.next.next.next = new ListNode(8);
        head2.next.next.next.next.next.next.next.next = new ListNode(9);
        head2.next.next.next.next.next.next.next.next.next = new ListNode(10);
        int M2 = 3;
        int N2 = 2;

        System.out.println("Original Linked List:");
        printList(head2);

        ListNode result2 = retainAndDelete(head2, M2, N2);

        System.out.println("Modified Linked List:");
        printList(result2);

        System.out.println();

        // Test case 3
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(3);
        head3.next.next.next = new ListNode(4);
        head3.next.next.next.next = new ListNode(5);
        head3.next.next.next.next.next = new ListNode(6);
        head3.next.next.next.next.next.next = new ListNode(7);
        head3.next.next.next.next.next.next.next = new ListNode(8);
        head3.next.next.next.next.next.next.next.next = new ListNode(9);
        head3.next.next.next.next.next.next.next.next.next = new ListNode(10);
        int M3 = 1;
        int N3 = 1;

        System.out.println("Original Linked List:");
        printList(head3);

        ListNode result3 = retainAndDelete(head3, M3, N3);

        System.out.println("Modified Linked List:");
        printList(result3);
    }
}
