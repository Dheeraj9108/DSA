class Solution {
    int mod = (int)1e9+7;

    private int binaryExp(int a, int b) {
        if (b == 0)
            return 1;

        int half = binaryExp(a, b / 2);
        long res = (1L * half * half) % mod;
        if (b % 2 != 0)
            return (int) ((a * res) % mod);
        return (int) res;
    }

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int limit = (int) Math.ceil(Math.sqrt(n));

        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int q[] : queries) {
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];
            if (k >= limit) {
                for (int i = l; i <= r; i += k) {
                    nums[i] = (int) (((long) nums[i] * v) % mod);
                }
            } else {
                map.computeIfAbsent(k, key -> new ArrayList<>()).add(q);
            }
        }

        for (Map.Entry<Integer, List<int[]>> set : map.entrySet()) {
            long diff[] = new long[n];
            Arrays.fill(diff, 1);
            int k = set.getKey();
            for (int q[] : set.getValue()) {
                int l = q[0];
                int r = q[1];
                int v = q[3];

                diff[l] = (diff[l] * v) % mod;
                int step = (r - l) / k;
                int next = l + (step + 1) * k;
                if (next < n)
                    diff[next] = (diff[next] * binaryExp(v, mod - 2)) % mod;
            }

            for (int i = 0; i < n; i++) {
                if (i - k >= 0)
                    diff[i] = (diff[i] * diff[i - k]) % mod;
            }

            for (int i = 0; i < n; i++) {
                nums[i] = (int) ((nums[i] * diff[i]) % mod);
            }
        }
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}