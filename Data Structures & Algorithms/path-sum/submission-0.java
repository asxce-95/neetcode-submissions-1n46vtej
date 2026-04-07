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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    boolean dfs(TreeNode root, int sum, int targetSum){
        if(root == null){
            return false;
        }
        
        
        if(dfs(root.left, sum + root.val, targetSum) || dfs(root.right, sum + root.val, targetSum)){
            return true; 
        }
        if(root.left ==null && root.right == null && sum + root.val == targetSum){
            return true;
        }
        return false;
    }
}