class Solution {
    public int longestSubsequence(int[] nums) {
        int res= 0;
        int n = nums.length;
        boolean containsNonZero = false;
        for(int num : nums){
            res^=num;
            if(num > 0) containsNonZero = true;
        }
        if(res != 0) return n;
        else if (containsNonZero) return n-1;
        return 0; 
    }
}