class Solution {
   public String removeKdigits(String num, int k) {
        Stack<Integer> stk = new Stack<>();

        for(int i = 0;i<num.length();i++){
            int digit = num.charAt(i) - '0';
            if(stk.isEmpty() || stk.peek() < digit ){
                stk.push(digit);
            } else {
                while(!stk.isEmpty() && k!=0 && stk.peek() > digit){
                    stk.pop();
                    k--;
                }
                stk.push(digit);
            }
        }

        while(!stk.isEmpty() && k > 0) {
            stk.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        
        int i = sb.length()-1;
        while(i >= 0 && sb.charAt(i) == '0'){
            sb.setLength(sb.length()-1);
            i--;
        }

        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }
}