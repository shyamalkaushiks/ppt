class Node8 {
    int data;
    Node prev;
    Node next;

    Node8(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class Q8_DeleteNodeDoublyLinkList {
    public static Node deleteNode(Node head, int position) {
        if (head == null) {
            return null;
        }

        if (position == 1) {
            Node newHead = head.next;
            if (newHead != null) {
                newHead.prev = null;
            }
            return newHead;
        }

        Node current = head;
        int count = 1;

        while (current != null && count < position) {
            current = current.next;
            count++;
        }

        if (current == null) {
            return head; 
        }

        Node prevNode = current.prev;
        Node nextNode = current.next;

        if (prevNode != null) {
            prevNode.next = nextNode;
        }
        if (nextNode != null) {
            nextNode.prev = prevNode;
        }

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
        Node head = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(4);

        head.next = node2;
        node2.prev = head;
        node2.next = node3;
        node3.prev = node2;

        System.out.println("Original Linked list:");
        printLinkedList(head);

        int position = 3;
        head = deleteNode(head, position);

        System.out.println("Linked list after deleting node at position " + position + ":");
        printLinkedList(head);
    }
}
