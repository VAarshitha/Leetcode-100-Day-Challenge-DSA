import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26]; // Frequency array
        boolean[] inStack = new boolean[26]; // Check if a character is in the stack
        Stack<Character> stack = new Stack<>();

        // Count frequency of each character in the string
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Iterate through each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']--; // Decrease the frequency

            if (inStack[c - 'a']) {
                continue; // Skip if the character is already in the stack
            }

            // Remove characters that are larger than current character and can appear later
            while (!stack.isEmpty() && stack.peek() > c && freq[stack.peek() - 'a'] > 0) {
                inStack[stack.pop() - 'a'] = false;
            }

            // Add the current character to the stack
            stack.push(c);
            inStack[c - 'a'] = true;
        }

        // Build the result string
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}
