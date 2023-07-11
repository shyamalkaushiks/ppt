public class Q8_ArrayProduct {
    public static int getProduct(int[] arr) {
        int product = 1;
        for (int i = 0; i < arr.length; i++) {
            product *= arr[i];
        }
        return product;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int product1 = getProduct(arr1);
        System.out.println("Product of array elements: " + product1);

        int[] arr2 = {1, 6, 3};
        int product2 = getProduct(arr2);
        System.out.println("Product of array elements: " + product2);
    }
}
