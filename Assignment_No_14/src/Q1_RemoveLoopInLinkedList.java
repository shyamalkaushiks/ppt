class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Q1_RemoveLoopInLinkedList {
    public static void removeLoop(Node head) {
        if (head == null || head.next == null) {
            return; 
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break; 
            }
        }

        if (slow != fast) {
            return;
        }

        slow = head;

        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = null;
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
        node2.next = node3;
        node3.next = node2; 

        System.out.println("Linked list before removing the loop:");
        printLinkedList(head);

        removeLoop(head);

        System.out.println("Linked list after removing the loop:");
        printLinkedList(head);
    }
}
