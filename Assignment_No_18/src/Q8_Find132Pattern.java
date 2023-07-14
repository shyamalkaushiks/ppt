import java.util.Stack;

 class Solution6 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int s3 = Integer.MIN_VALUE;
        
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < s3) {
                return true;
            }
            
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                s3 = stack.pop();
            }
            
            stack.push(nums[i]);
        }
        
        return false;
    }
}

public class Q8_Find132Pattern {
    public static void main(String[] args) {
        Solution6 solution = new Solution6();
        int[] nums = {1, 2, 3, 4};
        boolean has132pattern = solution.find132pattern(nums);
        System.out.println("Has 132 Pattern: " + has132pattern);
    }
}
