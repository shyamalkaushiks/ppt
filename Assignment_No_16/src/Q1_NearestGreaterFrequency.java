import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1_NearestGreaterFrequency {
    public static int[] findNearestGreaterFrequency(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Map<Integer, Integer> nearestGreaterMap = new HashMap<>();

        for (int i = n - 1; i >= 0; i--) {
            int currentFrequency = frequencyMap.getOrDefault(arr[i], 0);
            frequencyMap.put(arr[i], currentFrequency + 1);

            if (nearestGreaterMap.containsKey(arr[i]) && frequencyMap.get(nearestGreaterMap.get(arr[i])) > currentFrequency) {
                result[i] = nearestGreaterMap.get(arr[i]);
            } else {
                int j = i + 1;
                while (j < n) {
                    if (frequencyMap.get(arr[j]) > currentFrequency) {
                        nearestGreaterMap.put(arr[i], arr[j]);
                        result[i] = j;
                        break;
                    }
                    j++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 4, 2, 1};
        int[] result = findNearestGreaterFrequency(arr);
        System.out.println(Arrays.toString(result)); 
    }
}
