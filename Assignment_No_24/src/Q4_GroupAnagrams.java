import java.util.HashMap;
import java.util.Map;

public class Q4_GroupAnagrams {
    public static int majorityElement(int[] nums) {
        int majorityCount = nums.length / 2;

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0) + 1;

            if (count > majorityCount) {
                return num;
            }

            countMap.put(num, count);
        }

        throw new IllegalArgumentException("Majority element not found");
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        int majorityElement1 = majorityElement(nums1);
        System.out.println("Output1: " + majorityElement1);

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        int majorityElement2 = majorityElement(nums2);
        System.out.println("Output2: " + majorityElement2);
    }
}
