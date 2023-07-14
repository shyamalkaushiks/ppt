import java.util.Stack;

public class Q5_ReverseString {
    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversedString = new StringBuilder();

        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }

        return reversedString.toString();
    }

    public static void main(String[] args) {
        String str = "GeeksforGeeks";
        String reversed = reverseString(str);
        System.out.println(reversed);
    }
}
