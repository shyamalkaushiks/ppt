public class Q7_SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        int left = binarySearch(nums, target, true);
        if (left == -1) {
            return result; // Target not found
        }

        int right = binarySearch(nums, target, false);

        result[0] = left;
        result[1] = right;
        return result;
    }

    private static int binarySearch(int[] nums, int target, boolean leftmost) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;

                if (leftmost) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] range = searchRange(nums, target);
        System.out.println("Starting position: " + range[0]);
        System.out.println("Ending position: " + range[1]);
    }
}
