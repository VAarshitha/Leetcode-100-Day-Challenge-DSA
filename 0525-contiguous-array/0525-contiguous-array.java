import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        // Map to store the first occurrence of each prefix sum
        HashMap<Integer, Integer> sumIndex = new HashMap<>();
        sumIndex.put(0, -1); // Initialize with prefix sum 0 at index -1
        
        int prefixSum = 0;
        int maxLength = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // Convert 0 to -1
            prefixSum += (nums[i] == 0) ? -1 : 1;
            
            if (sumIndex.containsKey(prefixSum)) {
                // Calculate the length of the subarray
                maxLength = Math.max(maxLength, i - sumIndex.get(prefixSum));
            } else {
                // Store the first occurrence of the prefix sum
                sumIndex.put(prefixSum, i);
            }
        }
        
        return maxLength;
    }
}
