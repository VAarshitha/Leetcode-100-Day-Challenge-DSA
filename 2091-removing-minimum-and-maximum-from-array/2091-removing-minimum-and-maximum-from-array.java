class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        
        // If there's only one element, we need only one deletion
        if (n == 1) return 1;

        // Find indices of the minimum and maximum elements
        int minIndex = 0, maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        // Calculate different options to remove both min and max
        int leftMost = Math.min(minIndex, maxIndex);
        int rightMost = Math.max(minIndex, maxIndex);

        // 1. Remove both from the left side
        int deleteFromLeft = rightMost + 1;

        // 2. Remove both from the right side
        int deleteFromRight = n - leftMost;

        // 3. Remove min from the left and max from the right (or vice versa)
        int deleteBothSides = (leftMost + 1) + (n - rightMost);

        // Find the minimum number of moves
        return Math.min(deleteFromLeft, Math.min(deleteFromRight, deleteBothSides));
    }
}
