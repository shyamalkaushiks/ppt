public class Q5_MaximumElement {
    public static int findMax(int[] arr, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return arr[startIndex];
        } else {
            int mid = (startIndex + endIndex) / 2;
            int leftMax = findMax(arr, startIndex, mid);
            int rightMax = findMax(arr, mid + 1, endIndex);
            return Math.max(leftMax, rightMax);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, -5, -4, 8, 6};
        int max = findMax(arr, 0, arr.length - 1);
        System.out.println("Maximum element: " + max);

        int[] arr2 = {1, 4, 45, 6, 10, -8};
        max = findMax(arr2, 0, arr2.length - 1);
        System.out.println("Maximum element: " + max);
    }
}
