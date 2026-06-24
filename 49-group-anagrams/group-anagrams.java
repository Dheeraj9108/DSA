class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] a = s.toCharArray();
            Arrays.sort(a);
            String temp = new String(a);
            map.computeIfAbsent(temp, k->new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}