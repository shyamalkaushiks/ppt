import java.util.LinkedList;
import java.util.Queue;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Q2_LeftViewBinaryTree {
    public static void printLeftView(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                if (i == 0) {
                    System.out.print(current.val + " ");
                }

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(5);
        root.right = new Node(2);
        root.right.left = new Node(3);
        root.right.right = new Node(1);
        root.right.left.left = new Node(6);
        root.right.left.right = new Node(7);

        System.out.println("Left view of the binary tree:");
        printLeftView(root);
    }
}
