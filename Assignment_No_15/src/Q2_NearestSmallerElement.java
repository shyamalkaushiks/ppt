import java.util.Arrays;
import java.util.Stack;

public class Q2_NearestSmallerElement {
    public static int[] findNearestSmallerElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            } else {
                result[i] = -1;
            }

            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 2};
        int[] nearestSmaller = findNearestSmallerElements(arr);
        System.out.println(Arrays.toString(nearestSmaller));
    }
}

