class Solution {
    private boolean isPossible(int[] piles, int h, int mid){
        int i = 0;
        long need = 0;
        while(i < piles.length){
            need += (int)Math.ceil((double)piles[i]/mid);
            i++;
        }

        return need <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0;i<piles.length;i++){
            max = Math.max(max, piles[i]);
        }

        int l = 1;
        int r = max;
        int ans = 0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(isPossible(piles, h, mid)){
                ans = mid;
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return ans;
    }
}