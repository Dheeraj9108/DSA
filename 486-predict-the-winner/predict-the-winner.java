class Solution {
    private int solve(int nums[], int i, int j, int dp[][]){
        if(i > j) {
            return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];

        int take_i = nums[i]+ Math.min(solve(nums,i+2,j,dp),solve(nums,i+1,j-1,dp));
        int take_j = nums[j]+ Math.min(solve(nums,i,j-2,dp),solve(nums,i+1,j-1,dp));

        return dp[i][j] = Math.max(take_i, take_j);
    }
    public boolean predictTheWinner(int[] nums) {
        int dp[][] = new int[nums.length][nums.length];
        for(int a[]:dp) Arrays.fill(a,-1);
        int total = 0;
        for(int ele : nums) total+=ele; 
        int scorep1 = solve(nums, 0, nums.length-1, dp);
        int scorep2 = total - scorep1;
        return scorep1 >= scorep2; 
    }
}