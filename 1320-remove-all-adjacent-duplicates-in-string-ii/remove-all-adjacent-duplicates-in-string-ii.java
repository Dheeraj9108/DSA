class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> stk = new Stack<>();

        int cnt = 0;
        for(int i = 0;i<s.length();i++){
            if( !stk.isEmpty() && s.charAt(i) == stk.peek().getKey()) {
                cnt = stk.peek().getValue()+1;
            } else {
                cnt = 1;
            }
            stk.push(new Pair<Character,Integer>(s.charAt(i),cnt));
            if(cnt == k){
                while(!stk.isEmpty() && cnt != 0){
                    stk.pop();
                    cnt--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!stk.isEmpty()){
            sb.append(stk.pop().getKey());
        }

        return sb.reverse().toString();
    }
}