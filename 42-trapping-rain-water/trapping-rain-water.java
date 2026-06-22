class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int pgel[] = new int[n];
        int pge = height[0];
        for(int i = 1;i<n;i++){
            if(height[i] < pge){
                pgel[i] = pge;
            } else {
                pge = height[i];
            }
        }

        int ngel[] = new int[n];
        int nge = height[n-1];
        for(int i = n-2;i>=0;i--){
            if(height[i] < nge){
                ngel[i] = nge;
            } else {
                nge = height[i];
            }
        }
        int ans = 0;
        for(int i = 0;i<n;i++){
            // System.out.println(ngel[i] + " - " + pgel[i]);
            int min = Math.min(ngel[i], pgel[i]);
            if(min != 0){
                ans+=min - height[i];
            }
        }
        return ans;
    }
}