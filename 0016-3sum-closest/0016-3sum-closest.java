import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // Step 1: Sort the array
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize closest sum

        for (int i = 0; i < nums.length - 2; i++) { // Step 2: Fix one element
            int left = i + 1; // Step 3: Initialize two pointers
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // Update closestSum if currentSum is closer to target
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // Move pointers based on the comparison with target
                if (currentSum < target) {
                    left++; // Need a larger sum
                } else if (currentSum > target) {
                    right--; // Need a smaller sum
                } else {
                    return currentSum; // Perfect match
                }
            }
        }

        return closestSum; // Return the closest sum found
    }
}
