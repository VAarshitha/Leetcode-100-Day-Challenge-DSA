class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // Create a DP table to store results of subproblems
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // If the first string is empty, all characters of the second string must be inserted
                if (i == 0) {
                    dp[i][j] = j;
                }
                // If the second string is empty, all characters of the first string must be removed
                else if (j == 0) {
                    dp[i][j] = i;
                }
                // If the characters are the same, no operation is required
                else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // If the characters are different, consider all possibilities and find the minimum
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], // Replace
                                    Math.min(dp[i - 1][j], // Remove
                                             dp[i][j - 1])); // Insert
                }
            }
        }

        // Return the result from the bottom-right corner of the table
        return dp[m][n];
    }
}
