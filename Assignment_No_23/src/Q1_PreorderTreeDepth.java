public class Q1_PreorderTreeDepth {
    public static int calculateDepth(String preorder) {
        int depth = 0;
        for (char c : preorder.toCharArray()) {
            if (c == 'n') {
                depth++;
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        String preorder = "nlnll";
        int depth = calculateDepth(preorder);
        System.out.println("Depth of the binary tree: " + depth);
    }
}
