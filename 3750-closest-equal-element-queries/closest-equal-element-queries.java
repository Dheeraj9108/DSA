class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0;i<nums.length;i++){
            map.computeIfAbsent(nums[i], k->new ArrayList<>()).add(i);
        }

        List<Integer> res = new ArrayList<>();
        for(int q : queries) {
            List<Integer> list = map.get(nums[q]);
            if(list.size() == 1) {
                res.add(-1);
            } else {
                int pos = Collections.binarySearch(list,q);
                int size = list.size();
                int minDist = Integer.MAX_VALUE;

                int lIdx = list.get((pos + 1)%size);
                int d1 = Math.abs(q - lIdx);
                minDist = Math.min(d1, n - d1);

                int rIdx = list.get((pos - 1 + size)%size);
                int d2 = Math.abs(q - rIdx);
                minDist = Math.min(minDist,Math.min(d2, n-d2));

                res.add(minDist);
            }
        }
        return res;
    }
}