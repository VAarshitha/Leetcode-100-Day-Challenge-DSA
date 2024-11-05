import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Convert wordDict to a HashSet for faster lookups
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        
        // Create a DP array to store results
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;  // Base case: empty string can always be segmented
        
        // Iterate over the length of the string
        for (int i = 1; i <= n; i++) {
            // Check all possible partitions
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;  // Break early if we found a valid segmentation
                }
            }
        }
        
        return dp[n];
    }
}
