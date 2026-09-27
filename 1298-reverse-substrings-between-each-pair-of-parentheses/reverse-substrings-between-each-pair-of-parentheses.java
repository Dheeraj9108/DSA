class Solution {
    public String reverseParentheses(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Integer> stk = new Stack<>();
        for(int i = 0;i<s.length();i++) {
            if(s.charAt(i) == '('){
                stk.push(res.length());
            } else if (s.charAt(i) == ')'){
                int idx = stk.pop();
                String rev = new StringBuilder(res.substring(idx)).reverse().toString();
                res.replace(idx, res.length(), rev);
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}