class Solution {

    private double dfs(Map<String, List<Pair<String, Double>>> adj, String s, String d,Set<String> seen){
        seen.add(s);

        if(!adj.containsKey(s)) return -1.0;

        if(s.equals(d)) return 1.0;

        for(Pair<String,Double> n : adj.get(s)){
            if(seen.contains(n.getKey())) continue;
            double w = dfs(adj,n.getKey(),d,seen);
            if(w != -1.0){
                return w * n.getValue();
            }
        }

        return -1.0;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair<String, Double>>> adj = new HashMap<>();

        for(int i = 0;i < equations.size();i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            adj.computeIfAbsent(u, k->new ArrayList<>()).add(new Pair<String, Double>(v, values[i]));
            adj.computeIfAbsent(v, k->new ArrayList<>()).add(new Pair<String, Double>(u, 1/values[i]));
        }

        double[] ans = new double[queries.size()];
        for(int i = 0;i< queries.size();i++){
            Set<String> seen = new HashSet<>();
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);
            ans[i] = dfs(adj,u,v,seen);
        }

        return ans;
    }
}