class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int one = 0;
        for(int num : nums) {
            if(num == 1) one++;
            else map.put(num, map.getOrDefault(num,0)+1);
        }   

        if(one != 0 && one%2 == 0) one--;
        int ans = one;
        for(int key : map.keySet()){
            int len = 0;
            while(map.containsKey(key) && map.get(key) > 1){
                key *= key;
                len+=2;
            }

            if(!map.containsKey(key)){
                len--;
            } else {
                len++;
            }
            ans = Math.max(ans,len);
        }
        return ans;
    }
}