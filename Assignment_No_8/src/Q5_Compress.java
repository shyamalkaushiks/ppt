
public class Q5_Compress {
	public static int compress(char[] chars) {
	    int n = chars.length; 
	    int i = 0; 
	    int count = 1; 
	    
	    for (int j = 1; j <= n; j++) {
	        if (j < n && chars[j] == chars[j - 1]) {
	            count++;
	        } else {
	            chars[i++] = chars[j - 1]; 
	            
	          
	            if (count > 1) {
	                String countStr = Integer.toString(count);
	                for (char c : countStr.toCharArray()) {
	                    chars[i++] = c;
	                }
	            }
	            
	            count = 1; 
	        }
	    }
	    
	    return i; 
	}
	public static void main(String[] args) {
		char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
		int newLength = compress(chars);

		System.out.println("New length: " + newLength);
		System.out.print("Compressed array: ");
		for (int i = 0; i < newLength; i++) {
		    System.out.print(chars[i] + " ");
		}

	}
}
