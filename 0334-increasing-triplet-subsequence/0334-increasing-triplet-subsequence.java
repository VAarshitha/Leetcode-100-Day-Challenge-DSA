public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        
        int first = Integer.MAX_VALUE;  // The smallest element found so far
        int second = Integer.MAX_VALUE; // The second smallest element found so far
        
        for (int num : nums) {
            if (num <= first) {
                // Update the first to be the smallest possible value
                first = num;
            } else if (num <= second) {
                // Update the second to be the middle value
                second = num;
            } else {
                // If num is greater than both first and second, we found a triplet
                return true;
            }
        }
        
        return false;
    }
}
