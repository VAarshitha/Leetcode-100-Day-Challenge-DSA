class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        // Initial window sum
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // Sliding window
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }
}
