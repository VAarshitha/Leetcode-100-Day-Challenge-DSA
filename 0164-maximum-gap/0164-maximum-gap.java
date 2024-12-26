import java.util.*;

class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        // Find the min and max values in the array
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // Calculate bucket size and count
        int n = nums.length;
        int bucketSize = Math.max(1, (max - min) / (n - 1)); // At least size 1
        int bucketCount = (max - min) / bucketSize + 1;

        // Initialize buckets
        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // Place numbers in buckets
        for (int num : nums) {
            int bucketIndex = (num - min) / bucketSize;
            bucketMin[bucketIndex] = Math.min(bucketMin[bucketIndex], num);
            bucketMax[bucketIndex] = Math.max(bucketMax[bucketIndex], num);
        }

        // Calculate the maximum gap
        int maxGap = 0;
        int prevMax = min;
        for (int i = 0; i < bucketCount; i++) {
            // Skip empty buckets
            if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) {
                continue;
            }
            // Update the max gap
            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }

        return maxGap;
    }
}
