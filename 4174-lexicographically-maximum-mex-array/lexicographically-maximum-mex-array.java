class Solution {
    public int[] maximumMEX(int[] nums) {
        int n = nums.length;
        int fre[] = new int[n+1];
        for(int ele : nums){
            if(ele <= n) fre[ele]++;
        }
        int mex = 0;
        while(mex <=n && fre[mex] > 0){
            mex++;
        }

        int i = 0;
        List<Integer> ans = new ArrayList<>();
        while(i < n){
            if(mex == 0){
                ans.add(0);
                if(nums[i] <= n){
                    fre[nums[i]]--;
                }
                i++;
            } else {

                boolean seen[] = new boolean[n];
                int temp = mex;
                while(i < n && temp != 0){
                    int x = nums[i];
                    if(x <= mex && !seen[x]){
                        seen[x] = true;
                        temp--;
                    }

                    if(x <= n) fre[x]--;
                    i++;
                }
                ans.add(mex);

                mex = 0;
                while(mex <=n && fre[mex] > 0) {
                    mex++;
                }
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}