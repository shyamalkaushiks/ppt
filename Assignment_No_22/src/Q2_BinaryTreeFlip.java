public class Q2_BinaryTreeFlip {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public Node flipBinaryTree(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        Node flippedRoot = flipBinaryTree(root.left);

        root.left.left = root.right;
        root.left.right = root;
        root.left = root.right = null;

        return flippedRoot;
    }

    public void printInorder(Node root) {
        if (root == null) {
            return;
        }

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);

        Q2_BinaryTreeFlip flipper = new Q2_BinaryTreeFlip();
        System.out.println("Original Binary Tree (Inorder traversal):");
        flipper.printInorder(root);

        Node flippedRoot = flipper.flipBinaryTree(root);

        System.out.println("\nFlipped Binary Tree (Inorder traversal):");
        flipper.printInorder(flippedRoot);
    }
}
