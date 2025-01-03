class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x; // Base cases: sqrt(0) = 0, sqrt(1) = 1

        int left = 1, right = x / 2; // Search space is from 1 to x/2
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid; // Avoid overflow

            if (square == x) {
                return mid; // Exact square root
            } else if (square < x) {
                result = mid; // Update the result
                left = mid + 1; // Move to the right half
            } else {
                right = mid - 1; // Move to the left half
            }
        }

        return result; // Closest integer square root
    }
}
