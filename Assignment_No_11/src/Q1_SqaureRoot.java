public class Q1_SqaureRoot {
    public static int sqrt(int x) {
        if (x == 0)
            return 0;

        int left = 1, right = x;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid <= x / mid) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int x = 4;
        int sqrtResult = sqrt(x);
        System.out.println("Square root of " + x + " is " + sqrtResult);
    }
}
