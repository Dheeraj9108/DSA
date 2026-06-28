class Solution {
    private int solve(int[] prices, int day, int buy, int dp[][]){

        if(day >= prices.length){
            return 0;
        }

        if(dp[day][buy] != -1) return dp[day][buy];

        int take = 0;
        int skip = 0;
        if(buy == 1){
            take =  solve(prices,day+1, 0, dp) - prices[day]; 
        } else {
            take = prices[day] + solve(prices, day+1, 1, dp);
        }

        skip = solve(prices, day+1, buy, dp);

        return dp[day][buy] = Math.max(take,skip);

    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int states[]: dp) Arrays.fill(states,-1);
        return solve(prices, 0, 1, dp);
    }
}