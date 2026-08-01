class Solution {
    private boolean solve(int nums[], int i, int j, int player1, int player2, int turn){
        if(i > j) {
            if(player1 >= player2) return true;
            return false; 
        }

        if(turn == 1) {
            return solve(nums,i+1, j, player1+nums[i], player2, 0) || solve(nums,i, j-1, player1+nums[j], player2,0);
        } else {
            return solve(nums,i+1, j, player1, player2+nums[i],1) && solve(nums,i, j-1, player1, player2+nums[j],1);
        }

    }
    public boolean predictTheWinner(int[] nums) {
        return solve(nums,0,nums.length-1, 0,0,1);
    }
}