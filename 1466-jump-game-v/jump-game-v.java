// class Solution {

//     private int dfs(Map<Integer, List<Integer>> adj, int src, int dp[]){
//         if(dp[src] != -1) return dp[src];
//         int maxCnt = 0;
//         for(int nidx : adj.get(src)){
//             maxCnt = Math.max(maxCnt, dfs(adj,nidx, dp));
//         }
//         return dp[src] = maxCnt+1;
//     }  

//     public int maxJumps(int[] arr, int d) {
//         int n = arr.length;
//         int dp[] = new int[n+1];
//         Arrays.fill(dp, -1);
//         Map<Integer, List<Integer>> map = new HashMap<>();
//         int max = 1;
//         for(int i = 0;i<n;i++){
//             int j = i-1;
//             map.put(i, new ArrayList<>());
//             while( j >= 0 && (i - j) <= d && arr[i] > arr[j]){
//                 map.get(i).add(j);
//                 j--;
//             }
//             j = i+1;
//             while(j < n && (j - i) <= d && arr[i] > arr[j]){
//                 map.get(i).add(j);
//                 j++;
//             }
//         }   

//         for(int i = 0;i < n;i++){
//             int ans = dfs(map, i, dp);
//             max = Math.max(max, ans);
//         }
//         return max;
//     }
// }

// // nge 
// // 12 -> 10

// // 10 -> 9 

// // 9 -> 7

class Solution {

    private int[] f;

    private void dfs(int[] arr, int id, int d, int n) {
        if (f[id] != -1) {
            return;
        }
        f[id] = 1;
        for (int i = id - 1; i >= 0 && id - i <= d && arr[id] > arr[i]; --i) {
            dfs(arr, i, d, n);
            f[id] = Math.max(f[id], f[i] + 1);
        }
        for (int i = id + 1; i < n && i - id <= d && arr[id] > arr[i]; ++i) {
            dfs(arr, i, d, n);
            f[id] = Math.max(f[id], f[i] + 1);
        }
    }

    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        f = new int[n];
        Arrays.fill(f, -1);
        for (int i = 0; i < n; ++i) {
            dfs(arr, i, d, n);
        }
        int ans = 0;
        for (int val : f) {
            ans = Math.max(ans, val);
        }
        return ans;
    }
}