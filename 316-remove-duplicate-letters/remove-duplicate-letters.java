class Solution {
    public String removeDuplicateLetters(String s) {
        boolean vis[] = new boolean[26];
        int lastIdx[] = new int[26];
        for(int i = 0;i<s.length();i++){
            lastIdx[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stk = new Stack<>();

        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            
            while(!vis[ch - 'a'] && !stk.isEmpty() && stk.peek() > ch && lastIdx[stk.peek() - 'a'] > i){
                vis[stk.peek() - 'a'] = false;
                stk.pop();
            }

            if(!vis[ch - 'a']){
                stk.push(ch);
                vis[ch - 'a'] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }

        return sb.reverse().toString();
    }
}