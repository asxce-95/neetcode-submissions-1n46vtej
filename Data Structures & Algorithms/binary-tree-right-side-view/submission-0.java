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
    public List<Integer> rightSideView(TreeNode root) {

        Deque<TreeNode> dq = new ArrayDeque<>();
        List<Integer> l = new ArrayList<>();

        if(root == null){
            return l;
        }
        dq.addLast(root);

        while(!dq.isEmpty()){

            TreeNode last = dq.peekLast();
            if(last != null){
                l.add(last.val);
            }

            int howManyToIterate = dq.size();

            for(int i = 0 ; i < howManyToIterate ; i++){
                TreeNode node = dq.removeFirst();
                if(node.left != null) dq.addLast(node.left);
                if(node.right != null) dq.addLast(node.right);
            }

        }

        return l;
        
    }
}
