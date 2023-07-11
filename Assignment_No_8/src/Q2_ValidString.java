public class Q2_ValidString {
    public static boolean checkValidString(String s) {
        int left = 0; // Counter for unmatched left parentheses
        int star = 0; // Counter for unmatched stars

        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == '*') {
                star++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                }
                else if (star > 0) {
                    star--;
                }
                else {
                    return false;
                }
            }
        }

        if (left == 0) {
            return true;
        }

        return star >= left;
    }

    public static void main(String[] args) {
        String s = "()";
        boolean isValid = checkValidString(s);
        System.out.println(isValid);
    }
}
