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
    Stack<TreeNode> path1 = new Stack();
    Stack<TreeNode> path2 = new Stack();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        constructPath(path1, root, p);
        constructPath(path2, root, q);
        // for (TreeNode item : path1) {
        //     System.out.print(item.val);
        // }
        // System.out.println();
        // for (TreeNode item : path2) {
        //     System.out.print(item.val);
        // }
        System.out.println(path1);
        System.out.println(path2);
        TreeNode ans = null;
        while(!path1.isEmpty() && !path2.isEmpty()){
            if(path1.peek().val == path2.peek().val){

                ans = path1.peek();

                System.out.println(ans);
                System.out.println(ans.val);
            }
            path1.pop();
            path2.pop();
        }
        return ans;
        
    }

    public boolean constructPath(Stack<TreeNode> path, TreeNode root, TreeNode p){
        if(root == null) return false;

        if(root.val == p.val){
            path.push(root);
            return true;
        }

        if(constructPath(path, root.left, p)){
            path.push(root);
            return true;
        }
        if(constructPath(path, root.right, p)){
            path.push(root);
            return true;
        }
        return false;
    }
}
