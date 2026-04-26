class Solution {
    int dir[][] = {{1,0},{-1,0},{0,-1},{0,1}};
    int m,n;
    private boolean solve(char grid[][],int pi,int pj,int i, int j, boolean vis[][]){
        vis[i][j] = true;

        for(int d[]:dir){
            int ni = i+d[0];
            int nj = j+d[1];
            if(ni < 0 || nj < 0 || ni >= m || nj >= n) continue;
            if(grid[ni][nj] != grid[i][j]) continue;
            if(ni == pi && nj == pj) continue;
            if(vis[ni][nj]) return true;
            if(solve(grid,i,j,ni,nj,vis)) return true;
        }
        return false;
    }

    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(!vis[i][j]) {
                    if(solve(grid,-1,-1,i,j,vis)) return true;
                }
            }
        }
        return false;
    }
}
