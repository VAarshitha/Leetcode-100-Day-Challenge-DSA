public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        
        String previous = countAndSay(n - 1); // Recursive call
        StringBuilder result = new StringBuilder();
        
        int count = 0;
        char currentChar = previous.charAt(0);
        
        for (int i = 0; i < previous.length(); i++) {
            if (previous.charAt(i) == currentChar) {
                count++;
            } else {
                result.append(count).append(currentChar); // Append count and char
                currentChar = previous.charAt(i); // Update the current character
                count = 1; // Reset count
            }
        }
        
        // Append the last group
        result.append(count).append(currentChar);
        
        return result.toString();
    }
}
