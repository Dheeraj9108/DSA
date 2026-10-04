class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        long sum = ((long)n*(n+1))/2;
        int ans[] = new int[n]; 
        if(target > sum || target < -sum) return new int[0];

        for(int i = 0;i<n;i++){
            ans[i] = i+1;
        }

        if(target == sum) return ans;

        long diff = sum - target;
        for(int i = n-1;i>=0;i--){
            if(ans[i] <= (diff/2)){
                diff-=2 * ans[i];
                ans[i] *= -1;
            } 

            if(diff == 0) break;
        }
        if(diff != 0) return new int[0];
        Arrays.sort(ans);
        return ans;
    }
}

// 1,2,3,4,5,6,7