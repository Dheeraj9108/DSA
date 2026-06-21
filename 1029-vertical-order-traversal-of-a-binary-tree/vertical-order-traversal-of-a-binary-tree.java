/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private void dfs(Map<Integer, PriorityQueue<Pair<Integer, Integer>>> map, TreeNode root, int col, int row){
        if(root == null) return;
        map.computeIfAbsent(col,k->new PriorityQueue<Pair<Integer,Integer>>((a,b)->{
            if(a.getKey() == b.getKey()) return a.getValue() - b.getValue();
            return a.getKey() - b.getKey();
        })).add(new Pair<Integer,Integer>(row,root.val));
        dfs(map,root.left,col-1, row+1);
        dfs(map,root.right,col+1, row+1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, PriorityQueue<Pair<Integer, Integer>>> map = new TreeMap<>();
        dfs(map,root,0,0);
        System.out.println(map);
        List<List<Integer>> list = new ArrayList<>();
        for(PriorityQueue<Pair<Integer, Integer>> p :map.values()){
            List<Integer> temp = new ArrayList<>();
            while(!p.isEmpty()){
                temp.add(p.poll().getValue());
            }
            list.add(temp);
        }
        return list;
    }
}