class Solution {
    public int longestValidParentheses(String s) {
        int i = 0;
        int j = 0;
        int op = 0;
        int cl = 0;
        int len = 0;
        while(j < s.length()){
            if(s.charAt(j) == '(') op++;
            else cl++;
            if(op < cl){
                i = j+1;
                op = 0;
                cl = 0;
            } else if (op == cl){
                len = Math.max(len, j-i+1);
            }
            j++;
        }
        int n = s.length();
        i = n-1;
        j = n-1;
        op = 0;
        cl = 0;
        while(j >= 0){
            if(s.charAt(j) == '(') op++;
            else cl++;
            if(cl < op){
                i = j-1;
                op = 0;
                cl = 0;
            } else if (op == cl){
                len = Math.max(len, i-j+1);
            }
            j--;
        }
        return len;
    }
}