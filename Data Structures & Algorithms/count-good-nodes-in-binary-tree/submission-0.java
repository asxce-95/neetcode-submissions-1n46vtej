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

    List<Integer> v = new ArrayList<>();
    Deque<Integer> dq = new ArrayDeque<>();

    public int goodNodes(TreeNode root) {

        gN(root);
        System.out.println(v);
        return v.size();
        
    }

    public void gN(TreeNode root){
        if(root  == null)
            return;


        int flag = 0;

        if(dq.peekLast() == null || root.val >= dq.peekLast()){
            flag = 1;
            dq.addLast(root.val);
            v.add(root.val);
        }

        gN(root.left);
        gN(root.right);

        if(flag == 1){
            dq.removeLast();
        }

        
    }
}
