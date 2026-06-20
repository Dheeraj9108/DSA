class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> res = new ArrayList<>();
        res.add(new int[]{1,0});
        res.add(new int[]{n,n-1});

        for(int[] r: restrictions){
            res.add(new int[]{r[0],r[1]});
        }

        Collections.sort(res,(a,b)->a[0] - b[0]);

        int m = res.size();
        for(int i = 1;i<m;i++){
            int d = res.get(i)[0] - res.get(i-1)[0];
            res.get(i)[1] = Math.min(res.get(i)[1],res.get(i-1)[1] + d);
        }

        for(int i = m-2;i>=0;i--){
            int d = res.get(i+1)[0] - res.get(i)[0];
            res.get(i)[1] = Math.min(res.get(i)[1],res.get(i+1)[1] + d);
        }

        int ans = 0;
        for(int i = 1;i<m;i++){
            int i1 = res.get(i)[0];
            int h1 = res.get(i)[1];

            int i2 = res.get(i-1)[0];
            int h2 = res.get(i-1)[1];

            int d = i1-i2;
            ans = Math.max(ans, (h1+h2+d)/2);
        }

        return ans;
    }
}

// p - h1 + p - h2

// 2p - h1 + h2