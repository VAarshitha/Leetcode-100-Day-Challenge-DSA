class Solution {
    public String reverseWords(String s) {
        String[] words=s.split("\\s+");
        StringBuilder res=new StringBuilder();
        for( String word:words){
            StringBuilder sb=new StringBuilder(word);
            res.append(sb.reverse().toString()).append(" ");
        }
        return res.toString().trim();
    }
}