class Solution {
    private void solve(List<List<Integer>> res, List<Integer> list, Set<String> set, List<Integer> ans, StringBuilder key){
        if(list.isEmpty()){
            // System.out.println(set);
            if(set.add(key.toString())){
                res.add(new ArrayList<>(ans));
            }
            return;
        }
        
        for(int i = 0;i<list.size();i++){
            int cur = list.remove(i);
            ans.add(cur);
            int len = key.length();
            solve(res,list,set,ans, key.append(cur+","));
            key.setLength(len);
            ans.remove(ans.size()-1);
            list.add(i,cur);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int num : nums) list.add(num);
        Set<String> set = new HashSet<>();
        solve(res,list,set,new ArrayList<>(), new StringBuilder());
        return res;
    }
}
