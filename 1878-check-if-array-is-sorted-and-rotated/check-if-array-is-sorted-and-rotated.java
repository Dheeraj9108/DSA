class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        for(int i = 0;i<(2*n);i++){
            boolean flag = true;
            for(int j = i+1;j<(i+n);j++){
                if(nums[j%n] < nums[(j-1)%n]){
                    flag = false;
                    break;
                }
            }
            if(flag) return true;
        }
        return false;
    }
}

// 3,4,5,1,2,3,4,5,1,2