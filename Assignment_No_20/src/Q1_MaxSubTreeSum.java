class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Q1_MaxSubTreeSum {
    static int maxSum = Integer.MIN_VALUE;

    public static int maxSubtreeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int currentSum = root.val + maxSubtreeSum(root.left) + maxSubtreeSum(root.right);
        maxSum = Math.max(maxSum, currentSum);

        return currentSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int maxSubtree = maxSubtreeSum(root);
        System.out.println("Maximum subtree sum: " + maxSubtree);
    }
}
