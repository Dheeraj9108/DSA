class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        List<int[]> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            list.add(new int[]{arr[i],i});
        }
        Collections.sort(list, (a,b)->a[0] - b[0]);

        int rank = 1;
        int ans[] = new int[n];
        for(int i = 0;i<n;i++){
            if(i!=0 && list.get(i)[0] != list.get(i-1)[0]){
                rank++;
            }
            ans[list.get(i)[1]] = rank;
        }
        return ans;
    }
}