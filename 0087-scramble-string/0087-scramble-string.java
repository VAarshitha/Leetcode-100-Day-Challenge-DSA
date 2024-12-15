import java.util.HashMap;
import java.util.Map;

public class Solution {
    // Memoization map
    private final Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        // Base case: If the strings are equal
        if (s1.equals(s2)) {
            return true;
        }

        // If the sorted characters are not the same, they cannot be scrambles
        if (!isAnagram(s1, s2)) {
            return false;
        }

        // Create a unique key for memoization
        String key = s1 + "-" + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int n = s1.length();

        // Try splitting at every possible index
        for (int i = 1; i < n; i++) {
            // Case 1: No swap
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i))) {
                memo.put(key, true);
                return true;
            }
            // Case 2: Swap
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                isScramble(s1.substring(i), s2.substring(0, n - i))) {
                memo.put(key, true);
                return true;
            }
        }

        // If no valid split found
        memo.put(key, false);
        return false;
    }

    // Helper method to check if two strings are anagrams
    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            count[c - 'a']--;
        }
        for (int n : count) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }
}
