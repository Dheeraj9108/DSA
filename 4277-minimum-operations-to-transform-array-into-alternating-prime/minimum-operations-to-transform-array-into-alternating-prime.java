class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int cnt = 0;

        for(int i = 0;i<n;i++){
            int num = nums[i];
            if(i%2 == 0){
                while(!isPrime(num)){
                    num++;
                    cnt++;
                }
            } else {
                while(isPrime(num)){
                    num++;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean isPrime(int num){
        if(num < 2) return false;

        for(int i = 2;i*i<=num;i++){
            if(num%i == 0) return false;
        }
        return true;
    }
}