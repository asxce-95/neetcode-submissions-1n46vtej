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
    public List<List<Integer>> levelOrder(TreeNode root) {

        Deque<TreeNode> dq = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        List<Integer> l2 = new ArrayList<>();
        l2.add(root.val);
        ans.add(l2);
        
        if(root.left != null)  dq.addLast(root.left);
        if(root.right != null) dq.addLast(root.right);

        while(!dq.isEmpty()){

            List<Integer> l = new ArrayList<>();
            Deque<TreeNode> temp = new ArrayDeque<>();

            while(!dq.isEmpty()){
                TreeNode node = dq.removeFirst();
                if(node!=null){
                    temp.addLast(node);
                    l.add(node.val);
                }
            }

            ans.add(l);

            while(!temp.isEmpty()){
                TreeNode node = temp.removeFirst();
                if(node!=null){

                    if(node.left != null)  dq.addLast(node.left);
                    if(node.right != null) dq.addLast(node.right);
                }
            }

        }

        return ans;

        
    }
}
