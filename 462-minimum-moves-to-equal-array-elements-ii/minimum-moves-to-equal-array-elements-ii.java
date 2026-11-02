class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int target = nums[nums.length/2];
        int res = 0;
        for(int ele : nums){
            res += Math.abs(ele - target);
        }
        return res;
    }
}