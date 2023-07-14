import java.util.Stack;

public class Q5_ReverseNumber {
    public static int reverseNumber(int num) {
        String numString = String.valueOf(num);
        Stack<Character> stack = new Stack<>();

        for (char c : numString.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversedNum = new StringBuilder();

        while (!stack.isEmpty()) {
            reversedNum.append(stack.pop());
        }

        return Integer.parseInt(reversedNum.toString());
    }

    public static void main(String[] args) {
        int num1 = 365;
        int reversedNum1 = reverseNumber(num1);
        System.out.println("Input: " + num1);
        System.out.println("Output: " + reversedNum1);

        int num2 = 6899;
        int reversedNum2 = reverseNumber(num2);
        System.out.println("Input: " + num2);
        System.out.println("Output: " + reversedNum2);
    }
}
