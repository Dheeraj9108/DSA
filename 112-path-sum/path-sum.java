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
    private boolean solve(TreeNode root, int targetSum){
        if(root == null) return false;
        if(root.left == null && root.right == null && targetSum - root.val == 0) return true;
        // if(root == null && targetSum == 0) return true;


        return solve(root.right, targetSum - root.val) || solve(root.left, targetSum - root.val);

    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null && targetSum == 0) return false;
        return solve(root, targetSum);
    }
}