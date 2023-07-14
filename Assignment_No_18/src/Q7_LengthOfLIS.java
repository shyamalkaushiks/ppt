import java.util.Arrays;

class Solution5 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLength = 1;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        return maxLength;
    }
}

public class Q7_LengthOfLIS {
    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int length = solution.lengthOfLIS(nums);
        System.out.println("Length of Longest Increasing Subsequence: " + length);
    }
}
