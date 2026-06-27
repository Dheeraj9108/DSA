class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int ans = 0;
        for(int num : set){
            int len = 0;
            int key = num;
            if(!set.contains(key-1)){
                while(set.contains(key)){
                    len++;
                    key++;
                }
            }
            ans = Math.max(ans,len);
        }
        return ans;
    }
}