class Node {
    int val;
    ListNode next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Q3_NthNodeFromEnd {
    public static ListNode findNthFromEnd(ListNode head, int N) {
        if (head == null || N <= 0) {
            return null; 
        }

        ListNode first = head;
        ListNode second = head;

        for (int i = 0; i < N; i++) {
            if (first == null) {
                return null; 
            }
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        return second;
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

        int N = 2; 

        ListNode result = findNthFromEnd(head, N);

        if (result != null) {
            System.out.println("The " + N + "th node from the end is: " + result.val);
        } else {
            System.out.println("Invalid input or node not found.");
        }
    }
}
