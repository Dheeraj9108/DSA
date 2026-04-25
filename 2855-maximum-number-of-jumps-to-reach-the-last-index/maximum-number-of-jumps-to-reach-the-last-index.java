class Solution {
    // private int solve(int i, int prev, int nums[], int target, int dp[][]){
    //     int temp = nums[i] - (prev >=0 ? nums[prev] : 0);
    //     if(i == nums.length-1) {
    //         if(Math.abs(temp) <= target) return 1;
    //         return Integer.MIN_VALUE;
    //     };

    //     if(dp[i][prev] != Integer.MIN_VALUE) return dp[i][prev];

    //     int take = Integer.MIN_VALUE;
    //     if(Math.abs(temp) <= target){
    //         take = 1+solve(i+1,i,nums,target,dp);
    //     }
    //     int skip = solve(i+1,prev,nums,target,dp);

    //     return dp[i][prev] = Math.max(take,skip); 
    // }
    private int solve(int i, int nums[], int target, int dp[]){
        if(i == nums.length-1) return 0;

        if(dp[i] != Integer.MIN_VALUE) return dp[i];

        int max = Integer.MIN_VALUE;
        for(int j = i+1;j<nums.length;j++){
            if(Math.abs(nums[j] - nums[i]) <= target){
                max = Math.max(max, 1+solve(j,nums,target,dp));
            }
        }
        return dp[i] = max;
    }
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int dp[]= new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        int ans = solve(0,nums,target,dp);
        return ans <= 0 ? -1 : ans;
        // int ans = solve(1,0,nums,target,dp);
        // return ans <= 0 ? -1 : ans;
        
    }
}