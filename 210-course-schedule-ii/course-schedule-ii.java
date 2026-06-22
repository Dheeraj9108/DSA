class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int e[]:prerequisites){
            int u = e[0];
            int v = e[1];
            adj.computeIfAbsent(v,k-> new ArrayList<>()).add(u);
        }

        int indeg[] = new int[numCourses];
        for(int i = 0;i<numCourses;i++){
            for(int v : adj.getOrDefault(i, new ArrayList<>())){
                indeg[v]++;
            }
        }

        Queue<Integer> a = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            if(indeg[i] == 0){
                a.offer(i);
            }
        }

        int ans[] =  new int[numCourses];
        int k = 0;
        while(!a.isEmpty()){
            int cur = a.poll();
            ans[k++] = cur;
            for(int nei:adj.getOrDefault(cur, new ArrayList<>())){
                indeg[nei]--;
                if(indeg[nei] == 0) a.offer(nei);
            }
        }

        return k >= numCourses ? ans : new int[0];
    }
}