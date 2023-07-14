class Solution2 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int left = 0;
        int right = 0;
        
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
public class Q4_MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
        
        Solution2 solution = new Solution2();
        solution.moveZeroes(nums);
        
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
