import java.util.*;

public class Q6_Anagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        if (s == null || p == null || s.length() < p.length())
            return result;
        
        int[] pCount = new int[26]; 
        int[] sCount = new int[26]; 
        
        for (char c : p.toCharArray())
            pCount[c - 'a']++;
        
        for (int i = 0; i < p.length(); i++)
            sCount[s.charAt(i) - 'a']++;
        
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (Arrays.equals(pCount, sCount))
                result.add(i);
            
            sCount[s.charAt(i) - 'a']--;
            
            if (i + p.length() < s.length())
                sCount[s.charAt(i + p.length()) - 'a']++;
        }
        
        return result;
    }
    public static void main (String[] args) {
    	String s = "cbaebabacd";
    	String p = "abc";

    	Q6_Anagrams anagramIndices = new Q6_Anagrams();
    	List<Integer> indices = anagramIndices.findAnagrams(s, p);

    	System.out.println("Start indices of anagrams: " + indices);

    }
}
