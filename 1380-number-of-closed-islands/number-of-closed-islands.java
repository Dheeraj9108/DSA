class Solution {
    int dir[][] = {{1,0}, {-1, 0}, {0,1}, {0,-1}};
    int m;
    int n;
    private void dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 1 || grid[i][j] == 2) return ;

        grid[i][j] = 2;

        for(int d[] : dir){
            int ni = i + d[0];
            int nj = j + d[1];
            dfs(grid, ni, nj);
        }

    }
    public int closedIsland(int[][] grid) {
        n = grid[0].length;
        m = grid.length;
        int cnt = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i == 0 || j == 0 || i == m-1 || j == n-1){
                    dfs(grid, i, j);
                }
            }
        }

        for(int i = 1;i<m-1;i++){
            for(int j = 1;j<n-1;j++){
                if(grid[i][j] == 0){
                    dfs(grid, i, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}