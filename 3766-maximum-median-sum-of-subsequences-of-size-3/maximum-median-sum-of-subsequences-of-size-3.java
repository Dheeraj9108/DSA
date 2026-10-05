class Solution {
    public long maximumMedianSum(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        int i = 0;
        int j = nums.length-1;
        while(i < j){
            sum+=nums[j-1];
            i++;
            j-=2;
        }
        return sum;
    }
}

// 1 1 2 2 3 3