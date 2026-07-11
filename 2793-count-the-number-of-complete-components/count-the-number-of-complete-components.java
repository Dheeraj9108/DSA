class Solution {
    private Pair<Integer, Integer> dfs(int src, Map<Integer, List<Integer>> map, boolean vis[]){
        vis[src] = true;
        int nodes = 1;
        int edges = map.getOrDefault(src,new ArrayList<>()).size();
        for(int nei : map.getOrDefault(src, new ArrayList<>())){
            if(!vis[nei]){
                Pair<Integer, Integer> pair = dfs(nei,map,vis);
                nodes+=pair.getKey();
                edges+=pair.getValue();
            }
        }
        return new Pair<Integer, Integer>(nodes,edges);
    }
    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            adj.computeIfAbsent(u,k->new ArrayList<>()).add(v);
            adj.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }

        boolean[] vis = new boolean[n];
        int ans = 0;
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                Pair<Integer, Integer> pair = dfs(i,adj,vis);
                int nodes = pair.getKey();
                int e = pair.getValue()/2;
                int expected = (nodes*(nodes-1))/2;
                if(e == expected) ans++;
            }
        }
        return ans;
    }
}