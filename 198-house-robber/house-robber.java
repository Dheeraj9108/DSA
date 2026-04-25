class Solution {
    public int solve(int i, int []nums, int dp[]){
        if(i>=nums.length) return 0;

        if(dp[i] != -1) return dp[i];

        int take = nums[i] + solve(i+2,nums,dp);
        int skip = solve(i+1,nums,dp);

        return dp[i] = Math.max(take,skip);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+2];
        dp[n+1] = 0;
        dp[n] = 0;
        for(int i = n-1;i>=0;i--){
            dp[i] = Math.max(nums[i]+dp[i+2],dp[i+1]);
        }
        return dp[0];
        // return solve(0,nums,dp);
    }
}