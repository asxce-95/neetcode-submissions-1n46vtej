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

    int q = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int start = 0;
        int end = inorder.length;

        return tree(preorder, 0, end - 1, inorder);
        
        
    }

    public TreeNode tree(int[] pr, int is, int ie, int[] in){

        if(ie < is) return null;

        int t = pr[q++];
        int index = find(in, is, ie, t);

        TreeNode root = new TreeNode(in[index]);

        root.left = tree(pr, is, index-1, in);
        root.right = tree(pr, index + 1, ie, in);

        return root;

    }

    public int find(int[] in, int is, int ie, int t){
        for(int i = is; i <= ie ; i++){
            if(in[i] == t){
                return i;
            }
        }

        return -10001;
    }
}
