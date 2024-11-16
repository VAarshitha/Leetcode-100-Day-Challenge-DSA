import java.util.*;

class Solution {
    public String reverseWords(String s) {
        // Step 1: Split the string into words, trimming leading/trailing spaces
        String[] words = s.trim().split("\\s+");
        
        // Step 2: Reverse the words array
        Collections.reverse(Arrays.asList(words));
        
        // Step 3: Join the reversed words with a single space
        return String.join(" ", words);
    }
}
