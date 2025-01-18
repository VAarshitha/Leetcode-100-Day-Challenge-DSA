import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap to store groups of anagrams
        Map<String, List<String>> anagramMap = new HashMap<>();
        
        for (String str : strs) {
            // Sort the string to create the key
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = new String(charArray);
            
            // Add the string to the corresponding group in the map
            anagramMap.putIfAbsent(sortedKey, new ArrayList<>());
            anagramMap.get(sortedKey).add(str);
        }
        
        // Return all the groups as a list
        return new ArrayList<>(anagramMap.values());
    }
}
