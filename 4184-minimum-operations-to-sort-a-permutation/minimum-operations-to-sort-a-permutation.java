class Solution {
    public int minOperations(int[] nums) {
        int asc_cnt = 0;
        int dsc_cnt = 0;
        int n = nums.length;
        for(int i = 1;i<n;i++){
            asc_cnt += nums[i] == (nums[i-1]+1)%n ? 1 : 0;
            dsc_cnt += nums[i-1] == (nums[i]+1)%n ? 1 : 0;
        }

        if(asc_cnt == n-1 && nums[0] == 0) return 0;

        if(asc_cnt == n-1){
            int left = n - nums[0];
            int right = nums[n-1] + 1 + 2;
            return Math.min(left,right);
        }

        if(dsc_cnt == n-1){
            int left = n - nums[n-1] + 1;
            int right = ((nums[0] + 1)%n) + 1;
            return Math.min(left, right); 
        }

        return -1;
    }
}

// 3 2 1 0 5 4 
// 5 4  
// 4 5 0 1 2 3 