class Solution1 {
    public void sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        quicksort(nums, 0, nums.length - 1);
    }
    
    private void quicksort(int[] nums, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(nums, low, high);
            
            quicksort(nums, low, pivotIndex - 1);
            quicksort(nums, pivotIndex + 1, high);
        }
    }
    
    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        
        swap(nums, i + 1, high);
        
        return i + 1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
public class Q3_SortArray {
    public static void main(String[] args) {
        int[] nums = {5, 2, 9, 1, 3};
        
        Solution1 solution = new Solution1();
        solution.sortArray(nums);
        
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
