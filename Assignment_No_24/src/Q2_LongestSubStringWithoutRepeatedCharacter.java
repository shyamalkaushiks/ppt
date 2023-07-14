import java.util.HashSet;
import java.util.Set;

public class Q2_LongestSubStringWithoutRepeatedCharacter {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int i = 0, j = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();

        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                maxLength = Math.max(maxLength, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        int length1 = lengthOfLongestSubstring(s1);
        System.out.println("Output1: " + length1);

        String s2 = "bbbbb";
        int length2 = lengthOfLongestSubstring(s2);
        System.out.println("Output2: " + length2);
    }
}
