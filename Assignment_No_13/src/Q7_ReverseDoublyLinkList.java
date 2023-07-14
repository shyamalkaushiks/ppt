class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class Q7_ReverseDoublyLinkList {
    public static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;
        Node previous = null;

        while (current != null) {
            previous = current.prev;
            current.prev = current.next;
            current.next = previous;
            current = current.prev;
        }

        head = previous.prev;

        return head;
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        Node node2 = new Node(8);
        Node node3 = new Node(4);
        Node node4 = new Node(2);

        head.next = node2;
        node2.prev = head;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;

        System.out.println("Original Linked list:");
        printLinkedList(head);

        Node reversedHead = reverseList(head);

        System.out.println("Reversed Linked list:");
        printLinkedList(reversedHead);
    }
}
