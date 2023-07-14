public class Q3_BinaryTreeToDoublyLinkedList {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    private Node prev;

    public Node convertToDLL(Node root) {
        if (root == null) {
            return null;
        }

        prev = null;

        Node head = convertToDLLHelper(root);

        while (head.left != null) {
            head = head.left;
        }

        return head;
    }

    public Node convertToDLLHelper(Node root) {
        if (root == null) {
            return null;
        }

        Node left = convertToDLLHelper(root.left);

        root.left = prev;

        if (prev != null) {
            prev.right = root;
        }

        prev = root;

        Node right = convertToDLLHelper(root.right);

        return (left != null) ? left : root;
    }

    public void printDLL(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.right.left = new Node(30);
        root.right.right = new Node(35);

        Q3_BinaryTreeToDoublyLinkedList converter = new Q3_BinaryTreeToDoublyLinkedList();
        Node head = converter.convertToDLL(root);

        System.out.println("Doubly Linked List:");
        converter.printDLL(head);
    }
}
