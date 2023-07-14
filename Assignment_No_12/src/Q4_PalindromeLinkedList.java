class ListNode4 {
    char val;
    ListNode next;

    ListNode4(char val) {
        this.val = val;
        this.next = null;
    }
}

public class Q4_PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; 
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode firstHalf = head;
        ListNode secondHalf = prev;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false; 
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode('R');
        head.next = new ListNode('A');
        head.next.next = new ListNode('D');
        head.next.next.next = new ListNode('A');
        head.next.next.next.next = new ListNode('R');

        if (isPalindrome(head)) {
            System.out.println("Yes, it is a palindrome");
        } else {
            System.out.println("No, it is not a palindrome");
        }
    }
}
