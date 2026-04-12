class Solution {
    private int solve(String word, int f1, int f2, int idx, int dp[][][]) {
        if (idx >= word.length())
            return 0;

        if (dp[f1+1][f2+1][idx] != -1)
            return dp[f1+1][f2+1][idx];
        int ch = word.charAt(idx) - 'A';
        int x = ch / 6;
        int y = ch % 6;
        int distf1 = 0;
        int distf2 = 0;
        if (f1 != -1) {
            int f1x = f1 / 6;
            int f1y = f1 % 6;
            distf1 = Math.abs(x - f1x) + Math.abs(y - f1y);
        }
        if (f2 != -1) {
            int f2x = f2 / 6;
            int f2y = f2 % 6;
            distf2 = Math.abs(x - f2x) + Math.abs(y - f2y);
        }

        int nextf1 = distf1 + solve(word, ch, f2, idx + 1, dp);
        int nextf2 = distf2 + solve(word, f1, ch, idx + 1, dp);
        return dp[f1+1][f2+1][idx] = Math.min(nextf1, nextf2);
    }

    public int minimumDistance(String word) {
        int n = word.length();
        int dp[][][] = new int[27][27][n + 1];
        for (int a[][] : dp) {
            for (int b[] : a) {
                Arrays.fill(b, -1);
            }
        }
        return solve(word, -1, -1, 0, dp);
    }
}