import java.util.*;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // A set to store unique 10-character-long substrings
        Set<String> seen = new HashSet<>();
        // A set to store substrings that are repeated
        Set<String> repeated = new HashSet<>();

        // Iterate through the string to get all 10-letter substrings
        for (int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);
            // If the substring is already in the seen set, add it to repeated set
            if (!seen.add(substring)) {
                repeated.add(substring);
            }
        }

        // Convert repeated substrings to a list and return
        return new ArrayList<>(repeated);
    }
}
