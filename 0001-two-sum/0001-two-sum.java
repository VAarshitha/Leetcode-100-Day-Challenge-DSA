import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a map to store numbers and their indices
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the array of numbers
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];  // Correct complement calculation
            
            // Check if complement exists in the map
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};  // Return indices of the two numbers
            }
            
            // Store the current number and its index in the map
            map.put(nums[i], i);
        }
        
        // If no solution is found, throw an exception
        throw new IllegalArgumentException("No valid two sum solution");
    }
}
