import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort intervals by their end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0; // Count of non-overlapping intervals
        int prevEnd = Integer.MIN_VALUE; // End time of the last added interval

        for (int[] interval : intervals) {
            if (interval[0] >= prevEnd) {
                // If the interval does not overlap, add it
                prevEnd = interval[1];
            } else {
                // If it overlaps, increment the removal count
                count++;
            }
        }

        return count;
    }
}
