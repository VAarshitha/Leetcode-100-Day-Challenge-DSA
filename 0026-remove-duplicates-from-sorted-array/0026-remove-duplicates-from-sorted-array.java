class Solution {
    public int removeDuplicates(int[] nums) {
        int start=0;
        for(int end=1;end<nums.length;end++){
            if(nums[start]!=nums[end]){
                start++;
                nums[start]=nums[end];
            }
        }
        return start+1;
    }
}