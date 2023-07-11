class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Q4_BinaryTreeFromString {
    private static int index;

    public static TreeNode buildTree(String s) {
        index = 0;
        return buildTreeHelper(s);
    }

    private static TreeNode buildTreeHelper(String s) {
        if (index >= s.length())
            return null;

        // Extract the value of the current node
        int start = index;
        while (index < s.length() && Character.isDigit(s.charAt(index)))
            index++;
        int val = Integer.parseInt(s.substring(start, index));

        TreeNode node = new TreeNode(val);

        // Check if there is a left child
        if (index < s.length() && s.charAt(index) == '(') {
            index++; // Skip the opening parenthesis
            node.left = buildTreeHelper(s);
        }

        // Check if there is a right child
        if (index < s.length() && s.charAt(index) == '(') {
            index++; // Skip the opening parenthesis
            node.right = buildTreeHelper(s);
        }

        index++; // Skip the closing parenthesis
        return node;
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null)
            return;

        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        String s = "4(2(3)(1))(6(5))";
        TreeNode root = buildTree(s);
        inorderTraversal(root);
    }
}
