import java.util.Stack;

public class Q7_PairWiseDestruction {
    public static int countWordsLeft(String[] sequence) {
        Stack<String> stack = new Stack<>();

        for (String word : sequence) {
            if (!stack.isEmpty() && stack.peek().equals(word)) {
                stack.pop();
            } else {
                stack.push(word);
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        String[] sequence1 = {"ab", "aa", "aa", "bcd", "ab"};
        int wordsLeft1 = countWordsLeft(sequence1);
        System.out.println("Number of Words Left in Sequence 1: " + wordsLeft1);

        String[] sequence2 = {"tom", "jerry", "jerry", "tom"};
        int wordsLeft2 = countWordsLeft(sequence2);
        System.out.println("Number of Words Left in Sequence 2: " + wordsLeft2);
    }
}
