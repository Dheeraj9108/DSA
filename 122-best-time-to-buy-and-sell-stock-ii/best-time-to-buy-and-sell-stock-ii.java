class Solution {
    private int solve(int[] prices, int day, int buy, int dp[][]) {

        if (day >= prices.length) {
            return 0;
        }

        if (dp[day][buy] != -1)
            return dp[day][buy];

        int take = 0;
        int skip = 0;
        if (buy == 1) {
            take = solve(prices, day + 1, 0, dp) - prices[day];
        } else {
            take = prices[day] + solve(prices, day + 1, 1, dp);
        }

        skip = solve(prices, day + 1, buy, dp);

        return dp[day][buy] = Math.max(take, skip);

    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+1][2];
        // for(int states[]: dp) Arrays.fill(states,-1);
        for (int day = prices.length - 1; day >= 0; day--) {
            for (int buy = 0; buy <= 1; buy++) {
                int take = 0;
                int skip = 0;
                if (buy == 1) {
                    take = dp[day+1][0] - prices[day];
                } else {
                    take = prices[day] + dp[day+1][1];
                }
                skip = dp[day+1][buy];
                dp[day][buy] = Math.max(take,skip);
            }
        }
        return dp[0][1];
    }
}