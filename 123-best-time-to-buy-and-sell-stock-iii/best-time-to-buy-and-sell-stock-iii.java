class Solution {
    private int solve(int[] prices, int day, int buy, int dp[][][], int txn) {

        if (day >= prices.length || txn == 0) {
            return 0;
        }

        if (dp[day][buy][txn] != -1)
            return dp[day][buy][txn];

        int take = 0;
        int skip = 0;
        if (buy == 1) {
            take = solve(prices, day + 1, 0, dp, txn) - prices[day];
        } else {
            take = prices[day] + solve(prices, day + 1, 1, dp, txn-1);
        }

        skip = solve(prices, day + 1, buy, dp, txn);

        return dp[day][buy][txn] = Math.max(take, skip);

    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n+1][2][3];
        for(int states[][]: dp) for(int subState[] : states) Arrays.fill(subState,-1);   
        return solve(prices,0,1,dp,2);
    }
}