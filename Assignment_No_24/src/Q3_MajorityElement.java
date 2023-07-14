import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q3_MajorityElement {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            List<String> group = anagramMap.getOrDefault(sortedStr, new ArrayList<>());
            group.add(str);
            anagramMap.put(sortedStr, group);
        }

        return new ArrayList<>(anagramMap.values());
    }

    public static void main(String[] args) {
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> anagramGroups1 = groupAnagrams(strs1);
        System.out.println("Output1: " + anagramGroups1);

        String[] strs2 = {""};
        List<List<String>> anagramGroups2 = groupAnagrams(strs2);
        System.out.println("Output2: " + anagramGroups2);
    }
}
