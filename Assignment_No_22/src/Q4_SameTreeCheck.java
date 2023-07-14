public class Q4_SameTreeCheck {
    public static boolean isSameTree(int[] inorder, int[] preorder, int[] postorder) {
        if (inorder.length != preorder.length || preorder.length != postorder.length) {
            return false;
        }

        int n = inorder.length;
        int preIndex = 0, postIndex = n - 1;

        return isSameTreeHelper(inorder, preorder, postorder, 0, n - 1, preIndex, postIndex);
    }

    public static boolean isSameTreeHelper(int[] inorder, int[] preorder, int[] postorder,
                                           int inStart, int inEnd, int preIndex, int postIndex) {
        if (preIndex >= preorder.length || postIndex < 0 || inStart > inEnd) {
            return true;
        }

        if (inorder[inStart] != preorder[preIndex] || inorder[inEnd] != postorder[postIndex]) {
            return false;
        }

        int rootVal = preorder[preIndex];
        int inIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                inIndex = i;
                break;
            }
        }

        if (inIndex == -1) {
            return false;
        }

        int leftSubtreeSize = inIndex - inStart;

        boolean isLeftSame = isSameTreeHelper(inorder, preorder, postorder, inStart, inIndex - 1,
                preIndex + 1, postIndex - leftSubtreeSize - 1);
        boolean isRightSame = isSameTreeHelper(inorder, preorder, postorder, inIndex + 1, inEnd,
                preIndex + leftSubtreeSize + 1, postIndex - 1);

        return isLeftSame && isRightSame;
    }

    public static void main(String[] args) {
        int[] inorder1 = {4, 2, 5, 1, 3};
        int[] preorder1 = {1, 2, 4, 5, 3};
        int[] postorder1 = {4, 5, 2, 3, 1};

        boolean isSame1 = isSameTree(inorder1, preorder1, postorder1);
        System.out.println("Output1: " + (isSame1 ? "Yes" : "No"));

        int[] inorder2 = {4, 2, 5, 1, 3};
        int[] preorder2 = {1, 5, 4, 2, 3};
        int[] postorder2 = {4, 1, 2, 3, 5};

        boolean isSame2 = isSameTree(inorder2, preorder2, postorder2);
        System.out.println("Output2: " + (isSame2 ? "Yes" : "No"));
    }
}
