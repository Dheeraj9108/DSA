class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }

    private int reverse(int n) {
        int res = 0;
        while(n != 0) {
            int rem = n%10;
            res = res*10 + rem;
            n/=10; 
        }
        return res;
    }
}