class Solution {
    private int solve(String word, int f1x, int f1y, int f2x, int f2y, int idx,int dp[][][][][]){
        if(idx >= word.length()) return 0;

        if(dp[f1x+1][f1y+1][f2x+1][f2y+1][idx] != -1) return dp[f1x+1][f1y+1][f2x+1][f2y+1][idx];
        int ch = word.charAt(idx) - 'A';
        int x = ch/6;
        int y = ch%6;
        int distf1 = 0;
        int distf2 = 0;
        if(f1x != -1 && f1y != -1) distf1 = Math.abs(x - f1x) + Math.abs(y - f1y);
        if(f2x != -1 && f2y != -1) distf2 = Math.abs(x - f2x) + Math.abs(y - f2y);

        int nextf1 = distf1 + solve(word,x,y,f2x,f2y,idx+1,dp);
        int nextf2 = distf2 + solve(word,f1x,f1y,x,y,idx+1,dp);
        return dp[f1x+1][f1y+1][f2x+1][f2y+1][idx] = Math.min(nextf1, nextf2);
    }
    public int minimumDistance(String word) {
        int n = word.length();
        int dp[][][][][] = new int[7][8][7][8][n+1];
        for(int a[][][][] : dp){
            for(int b[][][] : a){
                for(int c[][] : b){
                    for(int d[] : c) Arrays.fill(d,-1);
                }
            }
        }
        int ch = word.charAt(0) - 'A';
        int x = ch/6;
        int y = ch%6;
        return solve(word,-1,-1,-1,-1,0,dp);
    }
}