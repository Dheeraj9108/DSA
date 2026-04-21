class Union {
    int parent[];
    int size[];
    public Union(int n){
        parent = new int[n];
        size = new int[n];

        for(int i = 0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(size[px] > size[py]){
            parent[py] = px;
            size[px]+=size[py];
        } else {
            parent[px] = py;
            size[py]+=size[px];
        }
    }
}
class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        Union dsu = new Union(n);
        int hummingDist = 0;

        for(int e[] : allowedSwaps){
            dsu.union(e[0],e[1]);
        }
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            int root = dsu.find(i);
            map.computeIfAbsent(root, k->new ArrayList<>()).add(i);
        }

        for(List<Integer> group : map.values()){
            Map<Integer,Integer> count = new HashMap<>();

            for(int idx : group){
                count.put(source[idx], count.getOrDefault(source[idx],0)+1);
            }

            for(int idx : group){
                int tar = target[idx];
                if(count.getOrDefault(tar,0) > 0){
                    count.put(tar,count.get(tar)-1);
                } else {
                    hummingDist++;
                }
            }
        }
        return hummingDist;
    }
}