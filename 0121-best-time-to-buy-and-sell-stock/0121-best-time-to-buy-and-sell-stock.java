class Solution {
    public int maxProfit(int[] prices) { 
        int currsum=0;
        int maxprofit=0;
        for(int i=1;i<prices.length;i++){
           int diff=prices[i]-prices[i-1]; 
           currsum=Math.max(0,currsum+diff);
           maxprofit=Math.max(maxprofit,currsum);
        }
        
            return maxprofit;
        }
    }
