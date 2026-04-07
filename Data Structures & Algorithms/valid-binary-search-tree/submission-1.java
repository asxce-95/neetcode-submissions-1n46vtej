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
    List<Integer> l = new ArrayList();
    public boolean isValidBST(TreeNode root) {

        if(root == null) return true;

        inorder(root);
        System.out.println(l);

        int prev = l.get(0);
        boolean flag = true;
        for(int i : l){
            if(flag){
                flag = false;
                continue;
            }
            if(prev >= i)
                return false;
            prev = i ;
        }
        return true;
        
    }

    public void inorder(TreeNode root){
        if(root == null ) return;

        inorder(root.left);
        l.add(root.val);
        inorder(root.right);
    }


}
