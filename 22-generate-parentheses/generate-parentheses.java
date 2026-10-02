class Solution {
    List<String> ans = new ArrayList<>();
    public void solve(int op, int cl, StringBuilder sb){
        if(op == 0 && cl == 0){
            ans.add(sb.toString());
            return;
        }

        if(cl < op) return;

        if(op > 0){
            sb.append('(');
            solve(op-1,cl,sb); 
            sb.setLength(sb.length()-1);
        }
        if(cl > 0){
            sb.append(')');
            solve(op,cl-1,sb);
            sb.setLength(sb.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        solve(n-1,n,new StringBuilder("("));
        return ans;
    }
}

