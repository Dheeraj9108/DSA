class Solution {

    private int dfs(Map<Integer, List<Integer>> adj, int src, int dp[]){
        if(dp[src] != -1) return dp[src];
        int maxCnt = 0;
        for(int nidx : adj.get(src)){
            maxCnt = Math.max(maxCnt, dfs(adj,nidx, dp));
        }
        return dp[src] = maxCnt+1;
    }  

    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max = 1;
        for(int i = 0;i<n;i++){
            int j = i-1;
            map.put(i, new ArrayList<>());
            while( j >= 0 && (i - j) <= d && arr[i] > arr[j]){
                map.get(i).add(j);
                j--;
            }
            j = i+1;
            while(j < n && (j - i) <= d && arr[i] > arr[j]){
                map.get(i).add(j);
                j++;
            }
        }   

        for(int i = 0;i < n;i++){
            int ans = dfs(map, i, dp);
            max = Math.max(max, ans);
        }
        return max;
    }
}

// nge 
// 12 -> 10

// 10 -> 9 

// 9 -> 7