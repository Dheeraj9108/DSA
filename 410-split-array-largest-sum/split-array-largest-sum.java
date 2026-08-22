class Solution {
    public boolean isPossible(int nums[], int target, int k){
        int need = 0;
        int sum = 0;
        for(int num : nums){
            sum+=num;
            if(sum>target){
                sum = num;
                need++;
            }
        }
        need++;
        return need <= k;
    }
    public int splitArray(int[] nums, int k) {
        int total = 0;
        int max = 0;
        for(int num : nums){
            total+=num;
            max = Math.max(max,num);
        }
        int left = max;
        int right = total;
        int ans = -1;
        while(left <= right){
            int mid = (left+right)/2;
             
            if(isPossible(nums,mid, k)){
                ans = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return ans;
    }
}