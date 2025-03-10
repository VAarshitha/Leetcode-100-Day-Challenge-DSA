class Solution {
    public int strStr(String haystack, String needle) {
     int n=haystack.length();
     int m=needle.length();
     //if n is 0
     if(m==0){
        return -1;
     }  
     //trvaerse using sliding window
     for(int i=0;i<=n-m;i++){
        if(haystack.substring(i,i+m).equals(needle)){
            return i;
        }
     } 
     return -1;
    }
}