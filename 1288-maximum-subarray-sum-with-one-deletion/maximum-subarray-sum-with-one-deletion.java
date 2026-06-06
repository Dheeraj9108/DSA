class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int del = 0;
        int noDel = arr[0];
        int ans = arr[0];

        for(int i =1;i<n;i++){
            int prevNoDel = noDel;
            noDel = Math.max(arr[i], noDel+arr[i]);

            del = Math.max(prevNoDel, del+arr[i]);

            ans = Math.max(ans, Math.max(del,noDel));
        }

        return ans;
    }
}