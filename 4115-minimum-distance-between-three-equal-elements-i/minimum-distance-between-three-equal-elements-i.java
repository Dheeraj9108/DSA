class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int i = 1;i<n-1;i++){
            int num = nums[i];
            int leftIdx = -1;
            int rightIdx = -1;
            for(int j = i-1;j>=0;j--){
                if(nums[j] == num) {
                    leftIdx = j;
                    break;
                }
            }
            for(int k = i+1;k<n;k++){
                if(nums[k] == num) {
                    rightIdx = k;
                    break;
                }
            }
            if(leftIdx != -1 && rightIdx != -1) {
                int absValue = Math.abs(i-leftIdx) + Math.abs(leftIdx-rightIdx) + Math.abs(rightIdx-i);
                min = Math.min(min,absValue);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}