class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = Integer.MIN_VALUE;
        int n = costs.length;
        for(int i = 0;i<n;i++){
            max = Math.max(costs[i],max);
        }
        int temp[] = new int[max+1];
        for(int i = 0;i<n;i++){
            temp[costs[i]]++;
        }

        for(int i = 1;i<temp.length;i++){
            temp[i] = temp[i-1]+temp[i];
        }
        int ans[] = new int[n];
        for(int i = n-1;i>=0;i--){
            ans[temp[costs[i]]-1] = costs[i];
            temp[costs[i]]--;
        }
        int sum = 0;
        for(int i = 0;i<n;i++){
            if(sum+ans[i] <= coins) sum+=ans[i];
            else return i;
        }
        return n;
    }
}