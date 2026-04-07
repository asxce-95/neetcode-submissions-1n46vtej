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
    int c = 0;
    public boolean isBalanced(TreeNode root) {

        markDepth(root);
        printTree( root);
        return checkBalance(root);


        
    }

    public boolean checkBalance(TreeNode root) {

        if(root == null)
            return true;
        
        int lh = root.left != null ? root.left.val : 0;
        int rh = root.right != null ? root.right.val : 0;

            System.out.println(++c);
            System.out.println("value: " +root.val +" left = " + lh + " and right = " + rh);

        if(Math.abs(lh-rh) > 1){
            System.out.println();
            System.out.println();
            System.out.println("false hogaya");
            return false;
        }
        
        return checkBalance(root.left) && checkBalance(root.right);
        


        
    }

    public int markDepth(TreeNode root) {

        if(root == null){
            return 0;
        }

        int h =  1 + Math.max( markDepth(root.left), markDepth(root.right) );
        root.val = h;
        return h;
        
    }

    public void printTree(TreeNode root) {
        if(root == null){
            System.out.println("null");
        } else {
            System.out.println(root.val);
        
        printTree(root.left);
        printTree(root.right);
        }

        
    }


}
