class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;
        for(int j = 0;j<nums2.length;j++){
            int pos = findIdx(Math.min(j,nums1.length-1),nums2[j], nums1);
            if(pos != -1){
                max = Math.max(j - pos, max);
            }
        }    
        return max;
    }

    private int findIdx(int end, int target, int arr[]){
        int l = 0;
        int r = end;
        while(l<=r){
            int mid = (l+r)/2;
            if(arr[mid]  > target) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        if (l <= end && arr[l] <= target) return l;
        return -1;
    }
}
