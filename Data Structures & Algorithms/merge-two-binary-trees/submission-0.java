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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }

    TreeNode dfs(TreeNode root1, TreeNode root2){
        TreeNode root = new TreeNode();
        if(root1 != null && root2 != null){
            root.val = root1.val + root2.val;
        
            TreeNode l = dfs(root1.left, root2.left);
            TreeNode r = dfs(root1.right, root2.right);

            root.left = l;
            root.right = r;
            return root;


        } else if(root1 != null && root2 == null){
            root.val = root1.val;

            TreeNode l = dfs(root1.left, null);
            TreeNode r = dfs(root1.right, null);

            root.left = l;
            root.right = r;
            return root;

        } else if(root2 != null && root1 == null) {
            root.val = root2.val;
            TreeNode l = dfs(null, root2.left);
            TreeNode r = dfs(null, root2.right);

            root.left = l;
            root.right = r;
            return root;
        } else {
            return null;
        }
    }
}