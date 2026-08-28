class Solution {
    String res = "";
    int halfLen = 0;
    String midChar = "";
    private boolean solve(StringBuilder sb, int fre[], String target, int idx, boolean isGreater){
        if(idx == halfLen){
            String leftHalf = sb.toString();
            String rightHalf = new StringBuilder(leftHalf).reverse().toString();
            String str = leftHalf+midChar+rightHalf;
            if(str.compareTo(target) > 0){
                res = str;
                return true;
            }
            return false;
        }

        for(char ch = 'a'; ch <='z';ch++){
            if(fre[ch - 'a'] == 0) continue;

            if(!isGreater && ch < target.charAt(idx)) continue;

            sb.append(ch);
            fre[ch - 'a']--;
            boolean greater = isGreater || ch > target.charAt(idx);
            if(solve(sb,fre,target,idx+1,greater)) return true;
            sb.setLength(sb.length()-1);
            fre[ch - 'a']++;
        }
        return false;
    }
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int fre[] = new int[26];
        for(int i = 0;i<n;i++){
            fre[s.charAt(i) - 'a']++;
        }

        int oddCnt = 0;
        for(int i = 0;i<26;i++){
            if(fre[i] %2 != 0){
                oddCnt++;
                midChar = (char)(i + 'a') + "";
            } 
        }

        if(oddCnt > 1) return "";

        for(int i = 0;i<26;i++){
            fre[i]/=2;
        }

        halfLen = n/2;

        solve(new StringBuilder(), fre, target, 0, false);

        return res;
    }
}