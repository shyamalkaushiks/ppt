import java.util.LinkedList;
import java.util.Queue;

public class Q3_LevelOrderBSTCheck {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public static boolean isLevelOrderBST(int[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0) {
            return true;
        }

        int n = levelOrder.length;
        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(levelOrder[0]);
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < n) {
            TreeNode current = queue.poll();

            if (i < n && levelOrder[i] < current.val) {
                current.left = new TreeNode(levelOrder[i]);
                queue.offer(current.left);
                i++;
            }

            if (i < n && levelOrder[i] > current.val) {
                current.right = new TreeNode(levelOrder[i]);
                queue.offer(current.right);
                i++;
            }
        }

        return i == n;
    }

    public static void main(String[] args) {
        int[] levelOrder1 = {7, 4, 12, 3, 6, 8, 1, 5, 10};
        boolean result1 = isLevelOrderBST(levelOrder1);
        System.out.println("Output1: " + (result1 ? "Yes" : "No"));

        int[] levelOrder2 = {11, 6, 13, 5, 12, 10};
        boolean result2 = isLevelOrderBST(levelOrder2);
        System.out.println("Output2: " + (result2 ? "Yes" : "No"));
    }
}
