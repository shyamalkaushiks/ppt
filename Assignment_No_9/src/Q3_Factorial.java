public class Q3_Factorial {
    public static long factorial(int N) {
        long result = 1;
        for (int i = 1; i <= N; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        long result = factorial(N);
        System.out.println("Factorial of " + N + " is: " + result);

        N = 4;
        result = factorial(N);
        System.out.println("Factorial of " + N + " is: " + result);
    }
}
