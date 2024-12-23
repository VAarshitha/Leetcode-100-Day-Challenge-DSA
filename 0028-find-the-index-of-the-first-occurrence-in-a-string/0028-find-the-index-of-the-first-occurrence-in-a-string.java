class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        
        // If the needle is empty, return 0 as per problem definition
        if (n == 0) {
            return 0;
        }
        
        // Iterate through haystack with a sliding window of size n
        for (int i = 0; i <= m - n; i++) {
            // Check if substring of haystack matches needle
            if (haystack.substring(i, i + n).equals(needle)) {
                return i;
            }
        }
        
        // If no match is found, return -1
        return -1;
    }
}
