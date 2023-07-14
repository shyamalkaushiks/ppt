public class Q2_DistanceBetweenNodeBst {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    static Node findLCA(Node root, int node1, int node2) {
        if (root == null || root.val == node1 || root.val == node2) {
            return root;
        }

        if (root.val > node1 && root.val > node2) {
            return findLCA(root.left, node1, node2);
        } else if (root.val < node1 && root.val < node2) {
            return findLCA(root.right, node1, node2);
        } else {
            return root;
        }
    }

    static int findDistance(Node root, int nodeValue) {
        if (root == null) {
            return 0;
        }

        if (root.val == nodeValue) {
            return 0;
        } else if (root.val > nodeValue) {
            return 1 + findDistance(root.left, nodeValue);
        } else {
            return 1 + findDistance(root.right, nodeValue);
        }
    }

    static int findDistanceBetweenNodes(Node root, int node1, int node2) {
        Node lca = findLCA(root, node1, node2);
        int distance1 = findDistance(lca, node1);
        int distance2 = findDistance(lca, node2);
        return distance1 + distance2;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        root.right = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

        int node1 = 6;
        int node2 = 14;

        int distance = findDistanceBetweenNodes(root, node1, node2);

        System.out.println("The distance between the two keys: " + distance);
    }
}
