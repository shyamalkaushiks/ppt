public class Q2_MaximumCircularSubarraySum {
    public static int maxSubarraySum(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static int minSubarraySum(int[] nums) {
        int minSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.min(nums[i], currentSum + nums[i]);
            minSum = Math.min(minSum, currentSum);
        }

        return minSum;
    }

    public static int maxCircularSum(int[] nums) {
        int maxSubarraySum = maxSubarraySum(nums);
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int minSubarraySum = minSubarraySum(nums);
        int maxCircularSum = totalSum - minSubarraySum;

        return Math.max(maxSubarraySum, maxCircularSum);
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 3, -2};
        int maxSum = maxCircularSum(nums);
        System.out.println("Maximum Circular Subarray Sum: " + maxSum);
    }
}
