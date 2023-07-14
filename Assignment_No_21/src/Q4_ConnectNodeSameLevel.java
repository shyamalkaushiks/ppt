public class Q4_ConnectNodeSameLevel {
    static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node(int val) {
            this.val = val;
            left = right = next = null;
        }
    }

    public void connectNodes(Node root) {
        if (root == null)
            return;

        Node levelStart = root;
        while (levelStart != null) {
            Node current = levelStart;
            Node dummy = new Node(-1);
            Node prev = dummy;

            while (current != null) {
                if (current.left != null) {
                    prev.next = current.left;
                    prev = prev.next;
                }

                if (current.right != null) {
                    prev.next = current.right;
                    prev = prev.next;
                }

                current = current.next;
            }

            levelStart = dummy.next;
        }
    }

    public void printLevelOrder(Node root) {
        Node levelStart = root;
        while (levelStart != null) {
            Node current = levelStart;
            while (current != null) {
                System.out.print(current.val + " → ");
                current = current.next;
            }
            System.out.println("-1");
            levelStart = levelStart.left;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Q4_ConnectNodeSameLevel connect = new Q4_ConnectNodeSameLevel();
        connect.connectNodes(root);

        System.out.println("Output:");
        connect.printLevelOrder(root);
    }
}
