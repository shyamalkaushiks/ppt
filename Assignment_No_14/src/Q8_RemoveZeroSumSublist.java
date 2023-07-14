public class Q8_RemoveZeroSumSublist {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        boolean hasZeroSum = true;

        while (hasZeroSum) {
            hasZeroSum = false;
            int prefixSum = 0;
            ListNode sumNode = curr;

            while (sumNode != null) {
                prefixSum += sumNode.val;

                if (prefixSum == 0) {
                    curr = sumNode.next;
                    dummy.next = curr;
                    hasZeroSum = true;
                    break;
                }

                sumNode = sumNode.next;
            }

            if (!hasZeroSum) {
                curr = curr.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> -3 -> 3 -> 1
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(-3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(1);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Q8_RemoveZeroSumSublist solution = new Q8_RemoveZeroSumSublist();
        ListNode result = solution.removeZeroSumSublists(head);

        // Print the result: 3 -> 1
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.println("null");
    }
}
