class Solution {
    public int maxVowels(String s, int k) {
        int count=0;
        Set<Character> set=Set.of('a','e','i','o','u');
        //initial window
        for(int i=0;i<k;i++){
            if(set.contains(s.charAt(i))){
                count++;
            }
        }
        int maxcount=count;
        //slide window
        for(int i=k;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                count++;
            }
            if(set.contains(s.charAt(i-k))){
                count--;
            }
            maxcount=Math.max(count,maxcount);
        }
        return maxcount;
    }
}