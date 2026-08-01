class Solution {
    private int solve(int nums[], int i, int j){
        if(i > j) {
            return 0;
        }

        int take_i = nums[i]+ Math.min(solve(nums,i+2,j),solve(nums,i+1,j-1));
        int take_j = nums[j]+ Math.min(solve(nums,i,j-2),solve(nums,i+1,j-1));

        return Math.max(take_i, take_j);
    }
    public boolean predictTheWinner(int[] nums) {
        int total = 0;
        for(int ele : nums) total+=ele; 
        int scorep1 = solve(nums, 0, nums.length-1);
        int scorep2 = total - scorep1;
        return scorep1 >= scorep2; 
    }
}