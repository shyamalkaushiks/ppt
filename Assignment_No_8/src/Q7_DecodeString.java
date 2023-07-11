public class Q7_DecodeString {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int numStart = i;
                while (Character.isDigit(s.charAt(i + 1)))
                    i++;
                int num = Integer.parseInt(s.substring(numStart, i + 1));
                
                i += 2;
                
                String decodedString = decodeString(s.substring(i));
                
                for (int j = 0; j < num; j++)
                    result.append(decodedString);
                
                i += decodedString.length() + 1;
            } else if (s.charAt(i) == ']') {
                return result.toString();
            } else {
                result.append(s.charAt(i));
                i++;
            }
        }
        
        return result.toString();
    }
    public static void main(String[] args) {
    	String s = "3[a]2[bc]";

    	Q7_DecodeString decoder = new Q7_DecodeString();
    	String decodedString = decoder.decodeString(s);

    	System.out.println("Decoded string: " + decodedString);

    }
}
