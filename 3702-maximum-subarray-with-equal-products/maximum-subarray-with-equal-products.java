class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int res = 0;
        for(int i = 0;i<n;i++){
            long p = nums[i];
            long g = nums[i];
            long l = nums[i];
            for(int j = i+1;j<n;j++){
                p = p * nums[j];
                g = gcd(g, nums[j]);
                l = (l * nums[j]) / gcd(l, nums[j]);

                if(p > g * l) break;
                if(p == g * l) res = Math.max(res, j-i+1);
            }
        }
        return res;
    }

    public long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}