class Solution {
    public int findPeakElement(int[] nums) {

    if(nums.length == 1){
        return 0;
    }


    if(nums[0] > nums[1]){
        return 0;
    }
    if(nums[nums.length - 1] > nums[nums.length - 2]){
        return nums.length - 1;
    }


    int left = 1;
    int right = nums.length - 2;


        while (left <= right) {
            int middle = (left + right) / 2;
            if(nums[middle] > nums[middle -1] && nums[middle]> nums[middle+1]){
                return middle;
            }   


            if(nums[middle] < nums[middle - 1]) {
                right = middle - 1;
            }else {
                left = middle + 1;
            }
        }
        return -1;
    }
}