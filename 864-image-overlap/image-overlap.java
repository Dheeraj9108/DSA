class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        Map<String, Integer> map = new HashMap<>();
        List<int[]> A = new ArrayList<>();
        List<int[]> B = new ArrayList<>();
        int max = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if(img1[r][c] == 1){
                    A.add(new int[]{r,c});
                }
                if(img2[r][c] == 1){
                    B.add(new int[]{r,c});
                }
            }
        }

        for (int a[]: A) {
            for (int b[] : B) {
                String dist = (b[0] - a[0]) + "," + (b[1] - a[1]);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
                max = Math.max(max, map.get(dist));
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