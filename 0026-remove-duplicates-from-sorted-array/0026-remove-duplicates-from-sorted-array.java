class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0; // Pointer for the unique element position
        
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) { // If a new unique element is found
                i++;
                nums[i] = nums[j]; // Place the unique element at the next position
            }
        }
        
        return i + 1; // Length of the unique part
    }
}
