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
    private void solve(Map<Integer, List<int[]>> adj, TreeNode root){
        
        for(int[] nei: adj.getOrDefault(root.val, new ArrayList<>())){
            int nsrc = nei[0];
            if(nei[1] == 1){
                root.left = new TreeNode(nsrc);
                solve(adj,root.left);
            } else {
                root.right = new TreeNode(nsrc);
                solve(adj,root.right);
            }
        }
    }
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        Map<Integer, Integer> parentMap = new HashMap<>();

        for(int ele[] : descriptions){
            int parent = ele[0];
            int child = ele[1];
            int isLeft = ele[2]; 

            parentMap.put(child, parent);
            parentMap.put(parent, parentMap.getOrDefault(parent,null));
            adj.computeIfAbsent(parent, k-> new ArrayList<>()).add(new int[]{child, isLeft});
        }

        int parentKey = 0;
        for(Map.Entry<Integer,Integer> entrySet : parentMap.entrySet()){
            if(entrySet.getValue() == null){
                parentKey = entrySet.getKey();
                break;
            }
        }

        TreeNode root = new TreeNode(parentKey);
        solve(adj,root);

        return root;
    }
}