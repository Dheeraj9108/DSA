class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String str : strs){
            String temp = str;
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr);
            str = new String(chArr);
            map.computeIfAbsent(str, k -> new ArrayList<>()).add(temp);
        }

        return new ArrayList<>(map.values());
    }
}