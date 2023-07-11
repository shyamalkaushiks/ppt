public class Q6_ArithmaticProgression {
    public static int findNthTerm(int a, int d, int N) {
        int nthTerm = a + (N - 1) * d;
        return nthTerm;
    }

    public static void main(String[] args) {
        int a = 2;
        int d = 1;
        int N = 5;
        int nthTerm = findNthTerm(a, d, N);
        System.out.println("The " + N + "th term of the series is: " + nthTerm);

        a = 5;
        d = 2;
        N = 10;
        nthTerm = findNthTerm(a, d, N);
        System.out.println("The " + N + "th term of the series is: " + nthTerm);
    }
}
