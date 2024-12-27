class Solution {
    public boolean isPowerOfFour(int n) {
        // Check if n is positive and a power of 2 (only one bit set)
        // Additionally, ensure the bit is in the correct position for powers of 4
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}
