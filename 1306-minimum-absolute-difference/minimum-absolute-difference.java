class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        int n = arr.length;
        for(int i = 1;i<n;i++){
            minDiff = Math.min(minDiff, arr[i] - arr[i-1]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1;i<n;i++){
            if(arr[i] - arr[i-1] == minDiff){
                ans.add(List.of(arr[i-1], arr[i]));
            }
        }
        return ans;
    }
}