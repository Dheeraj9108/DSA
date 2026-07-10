class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int oneCnt = 0;
        for(int ele : nums){
            if(ele == 1) oneCnt++;
            else map.put(ele, map.getOrDefault(ele,0)+1);
        }

        if(oneCnt != 0 && oneCnt%2 == 0){
            oneCnt--;
        }
        int ans = oneCnt;
        for(int key : map.keySet()){
            int len = 0;
            while(map.containsKey(key) && map.get(key) > 1){
                key*=key;
                len+=2;
            }

            if(map.containsKey(key)) len++;
            else len--;

            ans = Math.max(ans,len);
        }
        return ans;
    }
}