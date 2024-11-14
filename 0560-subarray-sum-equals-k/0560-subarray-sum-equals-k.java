import java.util.HashMap;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        // HashMap to store cumulative sum frequencies
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1); // To handle the case when a subarray starts from index 0
        
        int currentSum = 0;
        int count = 0;
        
        for (int num : nums) {
            currentSum += num; // Update the cumulative sum
            
            // Check if there is a subarray that sums to k
            if (sumMap.containsKey(currentSum - k)) {
                count += sumMap.get(currentSum - k); // Add the count of subarrays that sum to k
            }
            
            // Update the map with the current sum frequency
            sumMap.put(currentSum, sumMap.getOrDefault(currentSum, 0) + 1);
        }
        
        return count; // Return the total count of subarrays
    }
}
