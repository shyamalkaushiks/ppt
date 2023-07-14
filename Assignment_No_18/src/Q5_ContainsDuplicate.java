import java.util.LinkedList;
import java.util.Queue;

class Solution3 {
    public boolean containsDuplicate(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        for (int num : nums) {
            if (queue.contains(num)) {
                return true;
            }
            queue.offer(num);
        }
        return false;
    }
}

public class Q5_ContainsDuplicate {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int[] nums = {1, 2, 3, 1};
        boolean containsDuplicate = solution.containsDuplicate(nums);
        System.out.println("Contains Duplicate: " + containsDuplicate);
    }
}
