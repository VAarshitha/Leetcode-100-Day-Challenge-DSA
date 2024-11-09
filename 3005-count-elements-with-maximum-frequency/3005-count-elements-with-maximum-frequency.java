import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxFrequencyElements(int[] nums) {
        // Step 1: Calculate the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Find the maximum frequency
        int maxFrequency = 0;
        for (int frequency : frequencyMap.values()) {
            maxFrequency = Math.max(maxFrequency, frequency);
        }
        
        // Step 3: Sum up the occurrences of elements with the maximum frequency
        int totalMaxFrequencyCount = 0;
        for (int frequency : frequencyMap.values()) {
            if (frequency == maxFrequency) {
                totalMaxFrequencyCount += frequency;
            }
        }
        
        return totalMaxFrequencyCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] nums1 = {1, 2, 2, 3, 1, 4};
        System.out.println(solution.maxFrequencyElements(nums1));  // Output: 4
        
        // Test case 2
        int[] nums2 = {1, 2, 3};
        System.out.println(solution.maxFrequencyElements(nums2));  // Output: 1
    }
}
