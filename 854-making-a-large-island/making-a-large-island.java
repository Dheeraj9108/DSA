class Solution {
    int dir[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    private int solve(int grid[][], int x, int y, int landId){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid.length || grid[x][y] != 1 ) return 0;

        grid[x][y] = landId;
        int oneCnt = 1;
        for(int d[] : dir){
            int nx = x+d[0];
            int ny = y+d[1];
            oneCnt+=solve(grid,nx,ny,landId);
        }
    
        return oneCnt;
    }
    public int largestIsland(int[][] grid) {
        int landId = 2;
        int max = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    int temp = solve(grid,i,j, landId);
                    max = Math.max(max,temp);
                    map.put(landId, temp);
                    landId++;
                }
            }
        }

        int m = grid.length;
        int n = grid[0].length;
        for(int  i = 0;i<m;i++){
            for(int j= 0;j<n;j++){
                if(grid[i][j] == 0){
                    int temp = 1;
                    Set<Integer> set = new HashSet<>();
                    
                    if(i-1 >= 0 && grid[i-1][j] > 1) 
                        set.add(grid[i-1][j]);

                    if(j-1 >= 0 && grid[i][j-1]> 1)
                        set.add(grid[i][j-1]);

                    if(i+1 < m && grid[i+1][j] > 1)
                        set.add(grid[i+1][j]);

                    if(j+1 < n  && grid[i][j+1]  > 1)
                        set.add(grid[i][j+1]);

                    for(int lId : set){
                        temp+=map.get(lId);
                    }
                    max = Math.max(temp,max);
                }
            }
        }

        return max;
    }
}


// [0,0,0,0,0,0,0],
// [0,1,1,1,1,0,0],
// [0,1,0,0,1,0,0],
// [1,0,1,0,1,0,0],
// [0,1,0,0,1,0,0],
// [0,1,0,0,1,0,0],
// [0,1,1,1,1,0,0]