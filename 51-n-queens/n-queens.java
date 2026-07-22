class Solution {
    Set<Integer> colsSet = new HashSet<>();
    int n;
    List<List<String>> ans = new ArrayList<>();
    private void solve(char board[][], int row){
        if(row == n){
            List<String> temp = new ArrayList<>();
            for(int i = 0;i<n;i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        for(int col = 0; col < n;col++){
            if(isPossible(board,row,col)){
                colsSet.add(col);
                board[row][col] = 'Q';
                solve(board,row+1);
                board[row][col] = '.';
                colsSet.remove(col);
            }
        }
    }

    private boolean isPossible(char board[][], int row, int col){
        if(colsSet.contains(col)) return false;

        int c = 0;
        for(int r = row;r>=0;r--){
            if(col+c < n && board[r][col+c] == 'Q')  return false;
            if(col-c >=0 && board[r][col-c] == 'Q')  return false;
            c++;
        }

        return true;
    }
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        char board[][] = new char[n][n];
        for(int i = 0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        solve(board,0);
        return ans;
    }
}