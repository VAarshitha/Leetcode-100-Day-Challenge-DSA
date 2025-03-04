public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i=0;i<=nums.length-1;i++) {
            result ^= nums[i];
        }
        return result;
    }
}
