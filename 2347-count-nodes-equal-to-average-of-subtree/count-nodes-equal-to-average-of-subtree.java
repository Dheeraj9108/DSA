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
    int ans = 0;
    private int[] solve(TreeNode root){
        if(root == null) return new int[]{0,0};
        int[] leftSum = solve(root.left);
        int[] rightSum = solve(root.right);

        int avg = (root.val + leftSum[0]+rightSum[0])/(leftSum[1]+rightSum[1]+1);
        if(avg == root.val) ans++;
        return new int[]{leftSum[0]+rightSum[0]+root.val, leftSum[1] + rightSum[1]+1};
    }

    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return ans;
    }
}