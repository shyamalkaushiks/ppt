public class Q4_Exponentiation {
    public static double calculateExponent(int N, int P) {
        double result = Math.pow(N, P);
        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        int P = 2;
        double result = calculateExponent(N, P);
        System.out.println(N + " raised to the power " + P + " is: " + result);

        N = 2;
        P = 5;
        result = calculateExponent(N, P);
        System.out.println(N + " raised to the power " + P + " is: " + result);
    }
}
