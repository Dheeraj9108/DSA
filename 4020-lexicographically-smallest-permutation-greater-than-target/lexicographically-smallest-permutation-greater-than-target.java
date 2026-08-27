class Solution {
    String res = "";
    private boolean solve(int fre[], StringBuilder sb, String target, int idx, boolean isGreater){
        if(idx >= target.length()) {
            if(isGreater){
                res = sb.toString();
                return true;
            }
            return false;
        }

        for(char ch = 'a';ch<='z';ch++){
            if(fre[ch - 'a'] == 0) continue;

            if(!isGreater && ch < target.charAt(idx)) continue;

            sb.append(ch);
            fre[ch - 'a']--;

            boolean greater = isGreater || ch > target.charAt(idx);
            if(solve(fre, sb, target, idx+1, greater)) return true;
            
            sb.setLength(sb.length()-1);
            fre[ch - 'a']++;
        }
        return false;
    }
    public String lexGreaterPermutation(String s, String target) { 
        int fre[] = new int[26];
        for(char ch : s.toCharArray()){
            fre[ch - 'a']++;
        }

        solve(fre, new StringBuilder(), target, 0, false);

        return res;
    }
}