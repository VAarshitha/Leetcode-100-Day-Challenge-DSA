class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int num:nums){
            result ^= num;
        }
        //System.out.print(result);
        return result;
    }
    }
