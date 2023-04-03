import java.util.Arrays;

public class ProductArray {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println(Arrays.toString(productArray(arr)));		
	}
	
	public static int[] productArray(int[] arr) {
		
	    int[] result = new int[arr.length]; 
	    
	    for (int i = 0; i < arr.length; i++) {
	        int product = 1;
	        for (int j = 0; j < arr.length; j++) {
	            if (i != j) {
	                product *= arr[j];
	            }
	        }
	        result[i] = product;
	    }
	    return result;
	}
}
