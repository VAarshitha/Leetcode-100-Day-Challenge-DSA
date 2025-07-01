class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // To handle subarrays starting at index 0

        int prefSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefSum += nums[i];

            if (k != 0) {
                prefSum %= k;
            }

            if (map.containsKey(prefSum)) {
                int prevIndex = map.get(prefSum);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(prefSum, i); // Store only first occurrence
            }
        }

        return false;
    }
}
