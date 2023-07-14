public class Q3_FlattenLinkedList {
    static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.bottom = null;
        }
    }

    public static Node flatten(Node head) {
        if (head == null || head.next == null) {
            return head; 
        }

        head.next = flatten(head.next);

        head = merge(head, head.next);

        return head;
    }

    public static Node merge(Node a, Node b) {
        if (a == null) {
            return b; 
        }
        if (b == null) {
            return a;
        }

        Node result;

        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b); 
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }

        result.next = null; 

        return result;
    }

    public static void printFlattenedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.bottom;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(19);
        head.next.next.next = new Node(28);

        head.bottom = new Node(7);
        head.next.bottom = new Node(20);
        head.next.next.bottom = new Node(22);
        head.next.next.next.bottom = new Node(35);

        head.bottom.bottom = new Node(8);
        head.next.bottom.bottom = new Node(50);
        head.next.next.bottom.bottom = new Node(40);

        head.bottom.bottom.bottom = new Node(30);
        head.next.next.bottom.bottom.bottom = new Node(45);

        System.out.println("Original Linked List:");
        printFlattenedList(head);

        head = flatten(head);

        System.out.println("Flattened Linked List:");
        printFlattenedList(head);
    }
}
