class Solution {
    private boolean isPossible(int[] bloomDay, int day, int m, int k){
        
        int j = 0;
        int cnt = 0;
        int bouquets = 0;
        while(j<bloomDay.length){
            if(bloomDay[j]<=day) cnt++;
            else cnt = 0;

            if(cnt == k) {
                bouquets++;
                cnt = 0;
            }

            j++;
        }
        return bouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for(int i = 0;i<bloomDay.length;i++){
            left = Math.min(left, bloomDay[i]);
            right = Math.max(right, bloomDay[i]);
        }
        int ans = -1;
        while(left <= right){
            int mid = (left+right)/2;
            System.out.println(mid);
            if(isPossible(bloomDay, mid, m, k)){
                ans = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return ans;
    }
}