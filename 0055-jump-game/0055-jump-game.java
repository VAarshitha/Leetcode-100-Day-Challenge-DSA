class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0; // The furthest index we can reach so far
        for (int i = 0; i < nums.length; i++) {
            // If the current index is beyond our reach, we cannot proceed
            if (i > maxReach) {
                return false;
            }
            // Update the maximum reach
            maxReach = Math.max(maxReach, i + nums[i]);
            // If we can reach or go beyond the last index, return true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
