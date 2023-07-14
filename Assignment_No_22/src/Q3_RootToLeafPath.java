import java.util.Stack;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Q3_RootToLeafPath {
    public static void printRootToLeafPaths(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Stack<Node> pathStack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            pathStack.push(current);

            if (current.left == null && current.right == null) {
                printPath(pathStack);
            }

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }

            if ((current.left == null && current.right != null) || (current.left != null && current.right == null)) {
                while (!stack.isEmpty() && (stack.peek().left == null && stack.peek().right == null)) {
                    Node leaf = stack.pop();
                    pathStack.pop();
                }
            }
        }
    }

    public static void printPath(Stack<Node> pathStack) {
        StringBuilder sb = new StringBuilder();
        for (Node node : pathStack) {
            sb.append(node.val).append("->");
        }
        sb.setLength(sb.length() - 2); 
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(5);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.right.right = new Node(4);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);

        System.out.println("Root-to-leaf paths:");
        printRootToLeafPaths(root);
    }
}
