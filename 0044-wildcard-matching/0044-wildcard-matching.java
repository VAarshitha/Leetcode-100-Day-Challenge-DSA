public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // Empty string matches empty pattern
        
        // Initialize DP for patterns starting with *
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[j] = dp[j - 1];
            }
        }
        
        for (int i = 1; i <= m; i++) {
            boolean prev = dp[0]; // Store dp[i-1][j-1]
            dp[0] = false; // Empty pattern can't match non-empty string
            for (int j = 1; j <= n; j++) {
                boolean temp = dp[j];
                if (p.charAt(j - 1) == '*') {
                    dp[j] = dp[j] || dp[j - 1];
                } else {
                    dp[j] = prev && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?');
                }
                prev = temp; // Update prev for next column
            }
        }
        
        return dp[n];
    }
}
