class Solution {
    private boolean solve(int arr[], int i, int vis[]) {
        if(i < 0 || i>= arr.length || vis[i] == 1) return false;
        if(arr[i] == 0) return true;

        vis[i] = 1;

        return solve(arr,i+arr[i],vis) || solve(arr,i-arr[i],vis);
    }
    public boolean canReach(int[] arr, int start) {
        return solve(arr,start,new int[arr.length]);
    }
}

