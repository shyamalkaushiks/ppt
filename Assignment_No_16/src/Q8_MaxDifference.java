import java.util.Stack;

public class Q8_MaxDifference {
    public static int maxDifference(int[] arr) {
        int n = arr.length;
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Calculate right smaller elements
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                rightSmaller[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        // Clear the stack
        stack.clear();

        // Calculate left smaller elements
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                leftSmaller[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        int maxDiff = 0;

        // Calculate maximum absolute difference
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(leftSmaller[i] - rightSmaller[i]);
            maxDiff = Math.max(maxDiff, diff);
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 8};
        int maxDiff1 = maxDifference(arr1);
        System.out.println("Max Difference 1: " + maxDiff1);

        int[] arr2 = {2, 4, 8, 7, 7, 9, 3};
        int maxDiff2 = maxDifference(arr2);
        System.out.println("Max Difference 2: " + maxDiff2);

        int[] arr3 = {5, 1, 9, 2, 5, 1, 7};
        int maxDiff3 = maxDifference(arr3);
        System.out.println("Max Difference 3: " + maxDiff3);
    }
}
