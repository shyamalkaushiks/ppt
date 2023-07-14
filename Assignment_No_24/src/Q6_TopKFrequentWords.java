public class Q6_TopKFrequentWords {
    public static int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;

        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            uglyNumbers[i] = min;

            if (min == factor2) {
                index2++;
                factor2 = uglyNumbers[index2] * 2;
            }

            if (min == factor3) {
                index3++;
                factor3 = uglyNumbers[index3] * 3;
            }

            if (min == factor5) {
                index5++;
                factor5 = uglyNumbers[index5] * 5;
            }
        }

        return uglyNumbers[n - 1];
    }

    public static void main(String[] args) {
        int n1 = 10;
        int uglyNumber1 = nthUglyNumber(n1);
        System.out.println("Output1: " + uglyNumber1);

        int n2 = 1;
        int uglyNumber2 = nthUglyNumber(n2);
        System.out.println("Output2: " + uglyNumber2);
    }
}
