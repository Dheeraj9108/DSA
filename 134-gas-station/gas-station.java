class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSpend = 0;
        int totalGain = 0;
        int n = gas.length; 
        for(int i = 0;i< n;i++){
            totalSpend+=cost[i];
            totalGain+=gas[i];
        }

        if(totalGain < totalSpend) return -1;

        int total = 0;
        int idx = -1;
        for(int i = 0;i<n;i++){
            total+=gas[i] - cost[i];
            if(total < 0){
                total = 0;
                idx = -1;
            } else if(idx == -1){
                idx = i;
            }
        }
        return idx;
    }
}