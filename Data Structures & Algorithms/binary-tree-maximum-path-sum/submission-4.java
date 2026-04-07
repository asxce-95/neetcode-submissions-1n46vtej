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
    int gmax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        int ans = maxIncluding(root);
        return Math.max(gmax, ans);
        
    }

    public int maxIncluding(TreeNode root){
        if(root == null) return 0;

        int leftSide = maxIncluding(root.left);
        int rightSide = maxIncluding(root.right);

        int brokenPathSum = leftSide + root.val + rightSide;

        gmax = Math.max(gmax, brokenPathSum);
        gmax = Math.max(gmax, root.val);
        gmax = Math.max(gmax, root.val + leftSide);
        gmax = Math.max(gmax, root.val + rightSide);

        return Math.max(root.val ,root.val + Math.max(leftSide, rightSide));
    }

}
