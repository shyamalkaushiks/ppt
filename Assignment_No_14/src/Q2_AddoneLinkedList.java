class Node2 {
    int data;
    Node next;

    Node2(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Q2_AddoneLinkedList {
    public static Node addOne(Node head) {
       
        head = reverseLinkedList(head);

        Node current = head;
        int carry = 1; 

        while (current != null) {
            int sum = current.data + carry;
            current.data = sum % 10; 

            carry = sum / 10; 

            if (carry == 0) {
                break; 
            }

            current = current.next; 
        }

        if (carry != 0) {
            Node newCarryNode = new Node(carry);
            current.next = newCarryNode;
        }

        head = reverseLinkedList(head);

        return head;
    }

    public static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        Node node2 = new Node(5);
        Node node3 = new Node(6);

        head.next = node2;
        node2.next = node3;

        System.out.println("Linked list before adding 1:");
        printLinkedList(head);

        head = addOne(head);

        System.out.println("Linked list after adding 1:");
        printLinkedList(head);
    }
}
