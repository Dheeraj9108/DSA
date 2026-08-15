class Solution {
    public int longestSubsequence(int[] nums) {
        int max = 0;
        for(int i = 0;i<32;i++){
            int zero = 0;
            int one = 0;
            for(int num : nums){
                int bit = 1<<i;
                if((num & bit) > 0 ) one++;
                else zero++;
            }
            if(one > 0) {
                max = Math.max(zero+1,max);
            }
            if(one % 2 != 0) {
                max = Math.max(max, one+zero);
            } else if (one > 0 && one %2 == 0){
                max = Math.max(max, (one-1)+zero);
            }
        }
        return max;
    }
}