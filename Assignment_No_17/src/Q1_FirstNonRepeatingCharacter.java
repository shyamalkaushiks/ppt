import java.util.LinkedList;
import java.util.Queue;

public class Q1_FirstNonRepeatingCharacter {
    public static int firstNonRepeatingChar(String s) {
        int n = s.length();
        int[] frequency = new int[26];
        Queue<Character> queue = new LinkedList<>();

        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (frequency[c - 'a'] == 1) {
                return i;
            }

            queue.offer(c);
        }

        while (!queue.isEmpty()) {
            char c = queue.poll();

            if (frequency[c - 'a'] == 1) {
                return s.indexOf(c);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        int index = firstNonRepeatingChar(s);
        System.out.println("Index of First Non-Repeating Character: " + index);
    }
}
