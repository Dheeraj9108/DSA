class Solution {
    private int solve(int i, int prev, int nums[], int target, int dp[][]){
        int temp = nums[i] - (prev >=0 ? nums[prev] : 0);
        if(i == nums.length-1) {
            if(temp >= -target && temp <= target) return 1;
            return Integer.MIN_VALUE;
        };

        if(dp[i][prev+1] != Integer.MIN_VALUE) return dp[i][prev+1];

        int take = Integer.MIN_VALUE;
        if(temp >= -target && temp <= target){
            take = 1+solve(i+1,i,nums,target,dp);
        }
        int skip = solve(i+1,prev,nums,target,dp);

        return dp[i][prev+1] = Math.max(take,skip); 
    }
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+2];
        for(int a[]: dp)Arrays.fill(a,Integer.MIN_VALUE);
        int ans = solve(1,0,nums,target,dp);
        return ans <= 0 ? -1 : ans;
    }
}