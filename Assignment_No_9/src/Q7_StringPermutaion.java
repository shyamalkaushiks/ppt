import java.util.ArrayList;
import java.util.List;

public class Q7_StringPermutaion {
    public static List<String> generatePermutations(String S) {
        List<String> permutations = new ArrayList<>();
        generatePermutationsHelper(S.toCharArray(), 0, permutations);
        return permutations;
    }

    private static void generatePermutationsHelper(char[] chars, int index, List<String> permutations) {
        if (index == chars.length - 1) {
            permutations.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            generatePermutationsHelper(chars, index + 1, permutations);
            swap(chars, index, i); // backtrack
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        String S = "ABC";
        List<String> permutations = generatePermutations(S);
        System.out.println("Permutations of " + S + ":");
        for (String permutation : permutations) {
            System.out.println(permutation);
        }

        S = "XY";
        permutations = generatePermutations(S);
        System.out.println("Permutations of " + S + ":");
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
