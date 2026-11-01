class Solution {
    public int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().orElse(0);
        int ans = 0;
        for(int ele : nums){
            ans+= (ele - min);
        }
        return ans;
    }
}

// 1 5 7 9