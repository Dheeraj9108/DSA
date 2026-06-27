class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],1);
        }

        int ans = 0;
        for(int i = 0;i<nums.length;i++){
            int key = nums[i];
            int len = 0;
            while(map.containsKey(key)){
                len+=map.get(key);
                map.remove(key);
                key--;
            }
            ans = Math.max(ans,len);
            map.put(nums[i],len);
        }
        return ans;
    }
}