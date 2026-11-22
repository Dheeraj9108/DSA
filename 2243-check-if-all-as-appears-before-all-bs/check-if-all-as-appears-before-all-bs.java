class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        for(int i = 1;i<n;i++){
            char prev = s.charAt(i-1);
            char cur = s.charAt(i);
            if(cur == 'a' && prev == 'b') return false;
        }
        return true;
    }
}