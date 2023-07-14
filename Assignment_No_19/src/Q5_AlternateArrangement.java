import java.util.*;

public class Q5_AlternateArrangement {
    public static void alternateArrange(int[] arr) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for (int num : arr) {
            if (num >= 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }

        int posIndex = 0, negIndex = 0;
        int i = 0;

        while (posIndex < positive.size() && negIndex < negative.size()) {
            arr[i++] = negative.get(negIndex++);
            arr[i++] = positive.get(posIndex++);
        }

        while (posIndex < positive.size()) {
            arr[i++] = positive.get(posIndex++);
        }

        while (negIndex < negative.size()) {
            arr[i++] = negative.get(negIndex++);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -4, -1, 4};
        alternateArrange(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        alternateArrange(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
