class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        int[] res = new int[]{-1, -1};
        for(int i = 0;i<n;i++){
            int num = target - nums[i]; 
            if( num != nums[i] && map.containsKey(num)){
                if(ans < (num * nums[i])){
                    ans = num * nums[i];
                    if(num > nums[i]) res = new int[]{map.get(num), i};
                    else res = new int[]{i, map.get(num)};
                }
            }
            map.put(nums[i],i);
        }
        return res;
    }
}