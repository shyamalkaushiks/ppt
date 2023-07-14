import java.util.LinkedList;
import java.util.Queue;

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Q2_Level10TreeTraversal {

    public static TreeNode1 constructBST(int[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0) {
            return null;
        }

        TreeNode1 root = new TreeNode1(levelOrder[0]);
        Queue<TreeNode1> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < levelOrder.length) {
            TreeNode1 current = queue.poll();

            if (i < levelOrder.length && levelOrder[i] < current.val) {
                current.left = new TreeNode1(levelOrder[i]);
                queue.offer(current.left);
                i++;
            }

            if (i < levelOrder.length && levelOrder[i] > current.val) {
                current.right = new TreeNode1(levelOrder[i]);
                queue.offer(current.right);
                i++;
            }
        }

        return root;
    }

    public static void inorderTraversal(TreeNode1 root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        int[] levelOrder = {7, 4, 12, 3, 6, 8, 1, 5, 10};
        TreeNode1 root = constructBST(levelOrder);

        System.out.println("BST:");
        inorderTraversal(root);
    }
}
