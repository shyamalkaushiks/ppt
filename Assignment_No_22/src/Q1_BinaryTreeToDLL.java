public class Q1_BinaryTreeToDLL {
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
    private Node head;

    public Node convertToDLL(Node root) {
        if (root == null) {
            return null;
        }

        prev = null;

        convertToDLLHelper(root);

        return head;
    }

    public void convertToDLLHelper(Node root) {
        if (root == null) {
            return;
        }

        convertToDLLHelper(root.left);

        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }

        prev = root;

        convertToDLLHelper(root.right);
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
        root.right.left = new Node(15);
        root.right.right = new Node(30);

        Q1_BinaryTreeToDLL converter = new Q1_BinaryTreeToDLL();
        Node head = converter.convertToDLL(root);

        System.out.println("Doubly Linked List (Inorder traversal):");
        converter.printDLL(head);
    }
}
