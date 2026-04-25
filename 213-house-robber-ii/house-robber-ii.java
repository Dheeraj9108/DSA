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

    public int solve2(int nums[], int start, int end){
        int n = nums.length;
        int dp[] = new int[n+2];
        for(int i = end-1;i>=start;i--){
            dp[i] = Math.max(nums[i]+dp[i+2],dp[i+1]);
        }
        return dp[start];
    }
    public int rob(int[] nums) {
        // int dp[][] = new int[nums.length+1][2];
        // for(int a[]:dp) Arrays.fill(a,-1);
        int n = nums.length;
        if(n == 1) return nums[0];
        int a = solve2(nums,0,n-1);
        int b = solve2(nums,1,n);
        System.out.println(a+"  "+b);
        return Math.max(a,b);        
    }
}