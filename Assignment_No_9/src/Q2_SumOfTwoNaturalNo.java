public class Q2_SumOfTwoNaturalNo {
    public static int sumOfNaturalNumbers(int n) {
        int sum = (n*(n+1))/2 ;
        return sum;
    }

    public static void main(String[] args) {
        int n = 3;
        int sum = sumOfNaturalNumbers(n);
        System.out.println("Sum of the first " + n + " natural numbers: " + sum);

        n = 5;
        sum = sumOfNaturalNumbers(n);
        System.out.println("Sum of the first " + n + " natural numbers: " + sum);
    }
}
