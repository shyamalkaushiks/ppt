import java.util.*;

public class Q4_BottomViewBinaryTree {
    static class Node {
        int val;
        int hd;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            hd = Integer.MAX_VALUE;
            left = right = null;
        }
    }

    public static void printBottomView(Node root) {
        if (root == null) {
            return;
        }

        int minHd = 0, maxHd = 0;

        Map<Integer, Integer> bottomViewMap = new TreeMap<>();

        Queue<Node> queue = new LinkedList<>();
        root.hd = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            minHd = Math.min(minHd, current.hd);
            maxHd = Math.max(maxHd, current.hd);

            bottomViewMap.put(current.hd, current.val);

            if (current.left != null) {
                current.left.hd = current.hd - 1;
                queue.add(current.left);
            }

            if (current.right != null) {
                current.right.hd = current.hd + 1;
                queue.add(current.right);
            }
        }

        for (int i = minHd; i <= maxHd; i++) {
            System.out.print(bottomViewMap.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        System.out.println("Bottom view of the binary tree:");
        printBottomView(root);
    }
}
