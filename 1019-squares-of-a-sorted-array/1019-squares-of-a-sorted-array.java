class Solution {
    public int[] sortedSquares(int[] nums) {
       int left=0;int right=nums.length-1;
       int[] res=new int[nums.length];
       for(int i=nums.length-1;i>=0;i--){
        if(Math.abs(nums[left])>Math.abs(nums[right])){
            res[i]=nums[left]*nums[left];
            left++;
        }else{
        res[i]=nums[right]*nums[right];
        right--;
        }
       }
       return res;
    }
}



 /*int n=nums.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=nums[i]*nums[i];
        }
        Arrays.sort(res);
    return res;*/