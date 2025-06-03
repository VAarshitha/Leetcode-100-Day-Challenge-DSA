class Solution {
    public int[] twoSum(int[] nums, int target) {
     HashMap<Integer,Integer> set =  new HashMap<>();
     for(int i=0;i<nums.length;i++){
     int diff=target-nums[i];
      if(set.containsKey(diff)){
        return new int[] {set.get(diff),i };
      }
      set.put(nums[i],i);
     }
     return null;
    }
}