class Solution {
    private Long solve(int i, int j, List<Integer> robot, List<Integer> posList, long dp[][]) {
        if(i >= robot.size()) return 0L;
        if(j >= posList.size()) return (long) 1e12;

        if(dp[i][j] != -1) return dp[i][j];

        long take = Math.abs(robot.get(i) - posList.get(j)) + solve(i+1,j+1,robot,posList,dp);
        long skip = solve(i,j+1,robot,posList,dp);

        return dp[i][j] = Math.min(take,skip);
    }
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a,b)->a[0] - b[0]);
        List<Integer> posList = new ArrayList<>();
        
        for(int f[]: factory){
            int pos = f[0];
            int limit = f[1];
            for(int i = 0;i<limit;i++){
                posList.add(pos);
            }
        }
        int n = robot.size();
        int m = posList.size();
        long dp[][] = new long[n+1][m+1];
        for(long a[]:dp) Arrays.fill(a,-1);

        return solve(0,0,robot,posList,dp);
    }
}