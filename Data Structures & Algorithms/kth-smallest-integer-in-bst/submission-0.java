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
    int k = 0;
    public int kthSmallest(TreeNode root, int find) {

        k = find;

        return kSmall(root);


        
    }

    public int kSmall(TreeNode root) {

        if(root == null) return -1;
        


        int left = kSmall(root.left);
        if(left != -1) return left;
        k--;
        if(k == 0) return root.val;
        int right = kSmall(root.right);
        if(right != -1) return right;

        return -1;


        
    }
}
