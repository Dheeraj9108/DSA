class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        int k = 0;
        Set<List<Integer>> ans = new HashSet<>();
        while(i < nums.length-2){
            j = i+1;
            k = nums.length-1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k]; 
                if(sum == 0){
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }

                if(sum < 0) j++;
                else if (sum > 0 ) k--;
            }
            i++;
        }
        return new ArrayList<>(ans);
    }
}


// -9,4,5,5