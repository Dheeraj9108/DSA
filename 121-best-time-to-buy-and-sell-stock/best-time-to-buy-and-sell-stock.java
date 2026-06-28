class Solution {
    public int maxProfit(int[] prices) {
        int pse = prices[0];
        int n = prices.length;
        int ans = 0;
        for(int i = 1;i<n;i++){
            if(pse > prices[i]){
                pse = prices[i];
            } else {
                ans = Math.max(ans, prices[i] - pse);
            }
        }
        return ans;
    }
}