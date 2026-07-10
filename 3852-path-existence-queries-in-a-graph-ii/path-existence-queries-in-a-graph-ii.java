class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int temp[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            temp[i] = new int[] { nums[i], i };
        }
        Arrays.sort(temp, (a, b) -> a[0] - b[0]);

        int pos[] = new int[n];
        for (int i = 0; i < n; i++) {
            pos[temp[i][1]] = i;
        }

        int LOG = 18;
        int dp[][] = new int[n][LOG];

        int r = 0;
        for (int l = 0; l < n; l++) {
            while (r + 1 < n && temp[r + 1][0] - temp[l][0] <= maxDiff)
                r++;

            dp[l][0] = r;
        }

        for (int k = 1; k < LOG; k++) {
            for (int node = 0; node < n; node++) {
                dp[node][k] = dp[dp[node][k - 1]][k - 1];
            }
        }

        int ans[] = new int[queries.length];
        int idx = 0;
        for (int e[] : queries) {
            int u = pos[e[0]];
            int v = pos[e[1]];

            if (u == v) {
                ans[idx++] = 0;
                continue;
            }

            if (u > v) {
                int t = u;
                u = v;
                v = t;
            }

            int cur = u;
            int dist = 0;
            for (int k = LOG - 1; k >= 0; k--) {
                if (dp[cur][k] < v) {
                    cur = dp[cur][k];
                    dist += (1 << k);
                }
            }

            if (dp[cur][0] >= v) {
                ans[idx++] = dist + 1;
            } else {
                ans[idx++] = -1;
            }
        }
        return ans;
    }
}
