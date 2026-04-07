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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        ArrayDeque<TreeNode> dq = new ArrayDeque<>();
        TreeNode head = root;
        while (head != null || !dq.isEmpty()) {
            while (head != null) {
                dq.addLast(head);
                ans.add(head.val);
                head = head.left;
            }
            head = dq.removeLast();

            head = head.right;
        }

        return ans;
    
    }
}