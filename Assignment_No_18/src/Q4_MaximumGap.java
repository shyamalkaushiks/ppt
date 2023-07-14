 class Solution2 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        
        radixSort(nums);
        
        int maxDiff = 0;
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            maxDiff = Math.max(maxDiff, diff);
        }
        
        return maxDiff;
    }
    
    private void radixSort(int[] nums) {
        int max = getMax(nums);
        
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(nums, exp);
        }
    }
    
    private int getMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }
    
    private void countingSort(int[] nums, int exp) {
        int n = nums.length;
        int[] output = new int[n];
        int[] count = new int[10];
        
        for (int num : nums) {
            int digit = (num / exp) % 10;
            count[digit]++;
        }
        
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            int digit = (num / exp) % 10;
            int index = count[digit] - 1;
            output[index] = num;
            count[digit]--;
        }
        
        System.arraycopy(output, 0, nums, 0, n);
    }
}

public class Q4_MaximumGap {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {3, 6, 9, 1};
        int maximumGap = solution.maximumGap(nums);
        System.out.println("Maximum Gap: " + maximumGap);
    }
}
