class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int r1 = 0; r1 < n; r1++) {
            for (int c1 = 0; c1 < n; c1++) {
                for (int r2 = 0; r2 < n; r2++) {
                    for (int c2 = 0; c2 < n; c2++) {
                        if (img1[r1][c1] == 1 && img2[r2][c2] == 1) {
                            String dist = (r2 - r1) + ","+ (c2 - c1);
                            map.put(dist, map.getOrDefault(dist, 0) + 1);
                            max = Math.max(max, map.get(dist));
                        }
                    }
                }
            }
        }
        return max;
    }
}

// [0,1,1,1]
// [0,1,1,1]
// [0,1,1,1]
// [0,0,0,0]





// [0,0,0,0]
// [1,1,1,0]
// [1,1,1,0]
// [1,1,1,0]