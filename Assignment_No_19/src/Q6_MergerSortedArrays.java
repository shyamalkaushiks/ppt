class Solution3 {
    public int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] merged = new int[n1 + n2];
        
        int i = 0; // Pointer for arr1
        int j = 0; // Pointer for arr2
        int k = 0; // Pointer for merged array
        
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }
        
        while (i < n1) {
            merged[k++] = arr1[i++];
        }
        
        while (j < n2) {
            merged[k++] = arr2[j++];
        }
        
        return merged;
    }
}
public class Q6_MergerSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 5};
        int[] arr2 = {2, 4, 6, 8};
        
        Solution3 solution = new Solution3();
        int[] merged = solution.mergeSortedArrays(arr1, arr2);
        
        for (int num : merged) {
            System.out.print(num + " ");
        }
    }
}
