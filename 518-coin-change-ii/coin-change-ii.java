class Solution {
    
    private int solve(int i,int amount, int[] coins, int[][] dp){
        if(amount  == 0) return 1;
        if(amount < 0 ) return 0;
        if(i >= coins.length) return 0;

        if(dp[i][amount] != -1) return dp[i][amount];

        int take = solve(i,amount - coins[i], coins, dp);
        int notTake = solve(i+1,amount, coins, dp);

        return dp[i][amount] = take + notTake;
    }

    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length+1][amount+1];
        for(int a[]:dp) Arrays.fill(a,-1);
        return solve(0,amount, coins, dp);
    }
}