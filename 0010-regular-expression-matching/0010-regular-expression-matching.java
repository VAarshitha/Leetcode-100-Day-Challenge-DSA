public class Solution {
    public boolean isMatch(String s, String p) {
        // dp[i][j] will be true if s[0..i-1] matches p[0..j-1]
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        
        // Base case: empty string matches with empty pattern
        dp[0][0] = true;
        
        // Handle patterns with '*' that can match empty string
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2]; // '*' can match zero occurrences of the previous char
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                
                if (pc == sc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1]; // If chars match or '.' is found
                } else if (pc == '*') {
                    // '*' can either represent 0 occurrences or more of the previous character
                    dp[i][j] = dp[i][j - 2] || (i > 0 && (sc == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
                }
            }
        }
        
        return dp[s.length()][p.length()];
    }
}
