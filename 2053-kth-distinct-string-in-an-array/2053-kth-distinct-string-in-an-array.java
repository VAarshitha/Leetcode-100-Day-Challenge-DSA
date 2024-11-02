class Solution {
    public String kthDistinct(String[] arr, int k) {
        
        int n = arr.length;
        HashMap <String, Integer> hm = new HashMap<>();
        int count = 0;

        for(int i=0;i<n;i++){
            if(hm.containsKey(arr[i])){
                int temp = hm.get(arr[i]);
                hm.put(arr[i], temp+1);
            }
            else{
                hm.put(arr[i], 1);
            }
        }

        int index = 0;

        for(int i=0;i<n;i++){
            if(hm.get(arr[i]) == 1){
                index = i;
                count++;
                if(k==count){
                    return arr[i];
                }
            }
        }
    return "";
    }
}