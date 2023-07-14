import java.util.*;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] counts = new int[nums.length];
        int[] indices = new int[nums.length];
        int[] temp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            indices[i] = i;
        }

        mergeSort(nums, indices, counts, temp, 0, nums.length - 1);

        List<Integer> result = new ArrayList<>();
        for (int count : counts) {
            result.add(count);
        }

        return result;
    }

    private void mergeSort(int[] nums, int[] indices, int[] counts, int[] temp, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(nums, indices, counts, temp, start, mid);
        mergeSort(nums, indices, counts, temp, mid + 1, end);

        merge(nums, indices, counts, temp, start, mid, end);
    }

    private void merge(int[] nums, int[] indices, int[] counts, int[] temp, int start, int mid, int end) {
        int leftStart = start;
        int leftEnd = mid;
        int rightStart = mid + 1;
        int rightEnd = end;
        int index = start;
        int rightCount = 0;

        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (nums[indices[rightStart]] < nums[indices[leftStart]]) {
                temp[index] = indices[rightStart];
                rightCount++;
                rightStart++;
            } else {
                temp[index] = indices[leftStart];
                counts[indices[leftStart]] += rightCount;
                leftStart++;
            }
            index++;
        }

        while (leftStart <= leftEnd) {
            temp[index] = indices[leftStart];
            counts[indices[leftStart]] += rightCount;
            leftStart++;
            index++;
        }

        while (rightStart <= rightEnd) {
            temp[index] = indices[rightStart];
            rightStart++;
            index++;
        }

        System.arraycopy(temp, start, indices, start, end - start + 1);
    }
}
public class Q2_CountSmaller {
    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};

        Solution solution = new Solution();
        List<Integer> counts = solution.countSmaller(nums);

        System.out.println(counts);
    }
}
