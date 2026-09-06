class Solution {
    int dp[][];

    private int solve(int i, int j, String s, String t) {
        if (j >= t.length())
            return 1;

        if (i >= s.length())
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int take = 0;
        if (s.charAt(i) == t.charAt(j))
            take = solve(i + 1, j + 1, s, t);
        int skip = solve(i + 1, j, s, t);
        return dp[i][j] = take + skip;
    }

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        dp = new int[m + 1][n + 1];
        // for(int row[] : dp) Arrays.fill(row,-1);

        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int take = 0;
                if (s.charAt(i) == t.charAt(j))
                    take = dp[i+1][j+1];
                int skip = dp[i+1][j];
                dp[i][j] = take + skip;
            }
        }
        return dp[0][0];
        // return solve(0, 0, s, t);
    }
}

//  r a b b i t
// r1          
// a  1          
// b    1       
// b      1      
// b        
// i
// t

// r a b b b i t     r a b b i t