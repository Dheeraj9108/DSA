class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();
        Map<String, String> map = new HashMap<>();
        for(List<String> l : knowledge) {
            String key = l.get(0);
            String val = l.get(1);
            map.put(key,val);
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == '('){
                StringBuilder key = new StringBuilder();
                i++;
                while(i < n && s.charAt(i) != ')') {
                    key.append(s.charAt(i));
                    i++;
                }
                String val = map.get(key.toString());
                sb.append(val == null ? '?' : val);
            } else {
                sb.append(s.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }
}