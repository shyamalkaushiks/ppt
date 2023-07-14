class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Q1_BinaryToBst {
    static int index = 0;

    public static void convertToBST(TreeNode root) {
        if (root == null)
            return;

        int size = countNodes(root);
        int[] values = new int[size];
        inorderTraversal(root, values);

        quickSort(values, 0, size - 1);

        index = 0;
        updateTree(root, values);
    }

    public static int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static void inorderTraversal(TreeNode root, int[] values) {
        if (root == null)
            return;

        inorderTraversal(root.left, values);
        values[index++] = root.val;
        inorderTraversal(root.right, values);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void updateTree(TreeNode root, int[] values) {
        if (root == null)
            return;

        updateTree(root.left, values);
        root.val = values[index++];
        updateTree(root.right, values);
    }

    public static void inorderTraversalPrint(TreeNode root) {
        if (root == null)
            return;

        inorderTraversalPrint(root.left);
        System.out.print(root.val + " ");
        inorderTraversalPrint(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(4);

        System.out.println("Binary Tree:");
        inorderTraversalPrint(root);

        convertToBST(root);

        System.out.println("\nBinary Search Tree:");
        inorderTraversalPrint(root);
    }
}
