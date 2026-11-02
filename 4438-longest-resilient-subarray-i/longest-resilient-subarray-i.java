class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = 1;
        for(int i = 0;i<n;i++){
            int sum = nums[i];
            int rem = nums[i]%k;
            for(int j = i+1;j<n;j++){
                // System.out.print(j);
                if(nums[j]%k == rem) sum+=nums[j];
                else break;
                if(sum%k == rem) ans = Math.max(ans, j-i+1);
            }
            // System.out.println();
        }
        return ans;
    }
}

// 2 5 8 2