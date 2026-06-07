class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int row = -1;
        int max = -1;
        for(int rw = 0;rw< mat.length;rw++){
            int r[] = mat[rw];
            int cnt = 0 ;
            for(int i = 0;i<r.length;i++){
                if(r[i] == 1) cnt++;
            }
            if(cnt > max ){
                max = cnt;
                row = rw; 
            }
        }

        return new int[]{row,max};
    }
}