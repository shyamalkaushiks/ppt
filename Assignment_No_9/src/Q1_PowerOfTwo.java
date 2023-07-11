public class Q1_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        
        return (n & (n - 1)) == 0;
    }
    public static void main(String[] args) {
    	int n = 16;

    	Q1_PowerOfTwo powerOfTwo = new Q1_PowerOfTwo();
    	boolean isPower = powerOfTwo.isPowerOfTwo(n);

    	System.out.println("Is power of two: " + isPower);

    }
}
