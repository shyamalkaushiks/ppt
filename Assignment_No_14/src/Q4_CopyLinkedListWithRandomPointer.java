public class Q4_CopyLinkedListWithRandomPointer {
    static class Node {
        int val;
        Node next, random;

        Node(int x) {
            val = x;
            next = random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create copy nodes and insert them after the original nodes
        Node current = head;
        while (current != null) {
            Node copyNode = new Node(current.val);
            copyNode.next = current.next;
            current.next = copyNode;
            current = copyNode.next;
        }

        // Step 2: Update random pointers of the copy nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Separate the original and copy lists
        current = head;
        Node newHead = head.next;
        Node copyCurrent = newHead;
        while (current != null) {
            current.next = current.next.next;
            if (copyCurrent.next != null) {
                copyCurrent.next = copyCurrent.next.next;
            }
            current = current.next;
            copyCurrent = copyCurrent.next;
        }

        return newHead;
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create the original linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.random = head.next.next;
        head.next.random = head.next.next.next;
        head.next.next.random = head.next;

        // Print the original linked list
        System.out.println("Original Linked List:");
        printLinkedList(head);

        // Create a copy of the linked list
        Node copyHead = copyRandomList(head);

        // Print the copied linked list
        System.out.println("Copied Linked List:");
        printLinkedList(copyHead);
    }
}
