class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int start=0;int windowsum=0;double maxsum=Integer.MIN_VALUE;
        for(int end=0;end<nums.length;end++){
            windowsum+=nums[end];
            if(end>=k-1){
                maxsum=Math.max(windowsum,maxsum);
                windowsum-=nums[start];
                start++;
            }
        }
        return maxsum/k;
    }
}