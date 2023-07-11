public class Q8_LetterSwap {
    public boolean canBeEqual(String s, String goal) {
        int n = s.length();
        
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
            count[goal.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0)
                return false;
        }
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                for (int j = i + 1; j < n; j++) {
                    if (s.charAt(j) == goal.charAt(i) && s.charAt(i) == goal.charAt(j))
                        return true;
                }
                return false;
            }
        }
        
        return true;
    }
    public static void main(String[] args) {
    	String s = "ab";
    	String goal = "ba";

    	Q8_LetterSwap letterSwap = new Q8_LetterSwap();
    	boolean canSwap = letterSwap.canBeEqual(s, goal);

    	System.out.println("Can swap: " + canSwap);

    }
}
