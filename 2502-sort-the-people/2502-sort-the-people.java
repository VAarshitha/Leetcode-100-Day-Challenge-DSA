class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int i;
        int n=names.length;
        HashMap<Integer,String> map=new HashMap<>();
        for(i=0;i<n;i++){
         map.put(heights[i],names[i]);
        }
        Arrays.sort(heights);
        for(i=0;i<n/2;i++){
            int temp=heights[i];
            heights[i]=heights[n-1-i];
            heights[n-1-i]=temp;
        }
        for(i=0;i<n;i++){
            names[i]=map.get(heights[i]);
        }
        return names;
    }
}