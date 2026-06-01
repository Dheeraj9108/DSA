class Solution {

    private int solve(int prev_idx, int idx, int nums[], int dp[][]){
        if(idx >= nums.length) return 0;

        if(dp[prev_idx+1][idx] != -1) return dp[prev_idx+1][idx];

        int take = 0;
        int skip = 0;
        if(prev_idx == -1 || nums[prev_idx] < nums[idx]){
            take = 1 + solve(idx, idx+1, nums,dp);
        }

        skip = solve(prev_idx,idx+1,nums,dp);

        return dp[prev_idx+1][idx] =  Math.max(take, skip);

    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        for(int a[]: dp) Arrays.fill(a,-1);
        return solve(-1, 0, nums, dp);
    }   
}