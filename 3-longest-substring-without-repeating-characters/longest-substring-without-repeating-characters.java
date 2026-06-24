class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        int ans = 0;
        while(j<s.length()){
            while(i< j && set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            ans = Math.max(set.size(),ans);
            j++;
        }
        return ans;
    }
}