import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        
        // Frequency map for characters in t
        HashMap<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        
        // Sliding window variables
        HashMap<Character, Integer> windowMap = new HashMap<>();
        int left = 0, right = 0, minLength = Integer.MAX_VALUE;
        int matched = 0, start = 0;

        while (right < s.length()) {
            // Expand the window
            char rightChar = s.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);
            
            if (targetMap.containsKey(rightChar) && 
                windowMap.get(rightChar).equals(targetMap.get(rightChar))) {
                matched++;
            }
            
            // Shrink the window
            while (matched == targetMap.size()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }
                
                char leftChar = s.charAt(left);
                if (targetMap.containsKey(leftChar)) {
                    if (windowMap.get(leftChar).equals(targetMap.get(leftChar))) {
                        matched--;
                    }
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                }
                left++;
            }
            right++;
        }
        
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
