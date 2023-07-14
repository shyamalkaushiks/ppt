import java.util.Arrays;
import java.util.Stack;

public class Q1_NextGreaterElement {
    public static int[] findNextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};
        int[] nextGreater = findNextGreaterElements(arr);
        System.out.println(Arrays.toString(nextGreater));
    }
}
