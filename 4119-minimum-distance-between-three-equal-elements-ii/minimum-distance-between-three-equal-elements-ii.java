class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            map.computeIfAbsent(nums[i], k->new ArrayList<>()).add(i);
            if(map.get(nums[i]).size() > 2) {
                List<Integer> temp = map.get(nums[i]);
                min = Math.min(min, 2 * (temp.get(temp.size()-1) - temp.get(temp.size()-3)));
            } 
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}