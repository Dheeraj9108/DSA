class Solution {
    private int solve(int i, int[] nums, int isFirst, int dp[][]){
        if(i>=nums.length) return 0; 
        
        if(i == nums.length-1){
            if(isFirst == 1) return 0;
            return nums[i];
        }

        if(dp[i][isFirst] != -1) return dp[i][isFirst];

        if(i == 0) isFirst = 1;
        int take = nums[i] + solve(i+2,nums,isFirst,dp);
        int skip = 0;
        if(i == 0) skip = solve(i+1,nums,0,dp);
        else skip = solve(i+1,nums,isFirst,dp);

        return dp[i][isFirst] = Math.max(take,skip);
    }
    public int rob(int[] nums) {
        int dp[][] = new int[nums.length+1][2];
        for(int a[]:dp) Arrays.fill(a,-1);
        return solve(0,nums,0,dp);        
    }
}