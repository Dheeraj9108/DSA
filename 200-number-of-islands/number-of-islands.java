class Solution {
    int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    private void solve(char[][] grid, int i, int j){
        grid[i][j] = '0';
        for(int d[]: dir){
            int ni = i+d[0];
            int nj = j+d[1];
            if(ni >=0 && ni <grid.length && nj >=0 && nj < grid[0].length && grid[ni][nj] == '1'){
                solve(grid, ni, nj);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == '1'){
                    solve(grid,i,j);
                    ans++;
                } 
            }
        }
        return ans;
    }
}