class Solution {
    int n ;
    List<String> ans = new ArrayList<>();
    private void solve(Map<String, PriorityQueue<String>> adj, String src){
        
        while(adj.get(src) != null && !adj.get(src).isEmpty()){
            String next = adj.get(src).poll();
            solve(adj,next);
        }
        
        ans.addFirst(src);

        // for(Pair<String,Integer> nextPair : adj.get(src)){
        //     String next = nextPair.getKey();
        //     int ticket = nextPair.getValue();
        //     if(!vis[ticket]) {
        //         sb.append(","+next);
        //         vis[ticket] = true;
        //         solve(adj,next,sb,vis);
        //         vis[ticket] = false;
        //         sb.setLength(sb.length()-4);
        //     }
        // }

    }

    public List<String> findItinerary(List<List<String>> tickets) {
        n = tickets.size();
        Map<String, PriorityQueue<String>> adj = new HashMap<>();

        for(int i = 0;i<n;i++){
            List<String> ticket = tickets.get(i);
            String from = ticket.get(0);
            String to = ticket.get(1);
            adj.computeIfAbsent(from, k-> new PriorityQueue<>()).add(to);
        }
       
        solve(adj, "JFK");
        return ans;
    }
}