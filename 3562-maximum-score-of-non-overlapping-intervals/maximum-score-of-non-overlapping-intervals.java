class Solution {
    int next[];
    Pair<Long, List<Integer>> dp[][];

    private Pair<Long, List<Integer>> solve(int idx, int cnt, List<List<Integer>> intervals) {
        if (idx >= intervals.size() || cnt == 0)
            return new Pair<Long, List<Integer>>(0L, new ArrayList<>());

        if (dp[idx][cnt] != null)
            return dp[idx][cnt];

        int nextIdx = next[idx];
        Pair<Long, List<Integer>> temp = solve(nextIdx, cnt - 1, intervals);
        List<Integer> l = new ArrayList<>(temp.getValue());
        l.add(intervals.get(idx).get(3));
        Collections.sort(l);
        Pair<Long, List<Integer>> take = new Pair<Long, List<Integer>>(temp.getKey() + intervals.get(idx).get(2), l);
        Pair<Long, List<Integer>> skip = solve(idx + 1, cnt, intervals);
        Pair<Long, List<Integer>> res = null;

        if (compare(take, skip)) {
            res = take;
        } else
            res = skip;

        return dp[idx][cnt] = res;
    }

    private boolean compare(Pair<Long, List<Integer>> a, Pair<Long, List<Integer>> b) {
        if (a.getKey() > b.getKey())
            return true;
        if (a.getKey() < b.getKey())
            return false;
        for (int i = 0; i < Math.min(a.getValue().size(), b.getValue().size()); i++) {
            if (a.getValue().get(i) < b.getValue().get(i)) {
                return true;
            }

            if (a.getValue().get(i) > b.getValue().get(i))
                return false;
        }
        return a.getValue().size() < b.getValue().size();
    }

    private int getNextIndex(List<List<Integer>> intervals, int curEnd) {
        int l = 0;
        int r = intervals.size() - 1;
        int ans = intervals.size();
        while (l <= r) {
            int mid = (l + r) / 2;
            if (intervals.get(mid).get(0) > curEnd) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int idx = 0;
        int n = intervals.size();
        dp = new Pair[n + 1][5];
        for (List<Integer> list : intervals) {
            list.add(idx++);
        }
        next = new int[n];
        Collections.sort(intervals, (a, b) -> {
            if (a.get(0) == b.get(0))
                return a.get(1) - b.get(1);
            return a.get(0) - b.get(0);
        });

        for (int i = 0; i < n; i++) {
            int end = intervals.get(i).get(1);
            next[i] = getNextIndex(intervals, end);
        }

        Pair<Long, List<Integer>> ans = solve(0, 4, intervals);

        // for (int idx = 0; idx <= n; idx++) {
        //     dp[idx][4] = new Pair<Long, List<Integer>>(0L, new ArrayList<>());
        // }

        // for (int idx = n - 1; idx > 0; idx--) {
        //     for (int cnt = 0; cnt <= 4; cnt++) {
        //         int nextIdx = next[idx];
        //         Pair<Long, List<Integer>> temp = dp[nextIdx][cnt-1];
        //         List<Integer> l = new ArrayList<>(temp.getValue());
        //         l.add(intervals.get(idx).get(3));
        //         Collections.sort(l);
        //         Pair<Long, List<Integer>> take = new Pair<Long, List<Integer>>(
        //                 temp.getKey() + intervals.get(idx).get(2), l);
        //         Pair<Long, List<Integer>> skip = dp[idx+1][cnt];
        //         Pair<Long, List<Integer>> res = null;

        //         if (compare(take, skip)) {
        //             res = take;
        //         } else
        //             res = skip;

        //         return dp[idx][cnt] = res;
        //     }
        // }

        int res[] = new int[ans.getValue().size()];
        for (int i = 0; i < ans.getValue().size(); i++) {
            res[i] = ans.getValue().get(i);
        }
        return res;
    }
}
