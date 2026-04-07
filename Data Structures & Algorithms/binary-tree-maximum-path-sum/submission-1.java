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
    int gmax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        int ans = maxIncluding(root);
        return Math.max(gmax, ans);
        
    }

    public int maxIncluding(TreeNode root){
        if(root == null) return 0;

        int leftSide = maxIncluding(root.left);
        int rightSide = maxIncluding(root.right);

        int brokenPathSum = leftSide + root.val + rightSide;

        gmax = Math.max(gmax, brokenPathSum);
        gmax = Math.max(gmax, root.val);

        return Math.max(root.val ,root.val + Math.max(leftSide, rightSide));
    }


    public int maxTill(TreeNode root, int parent) {

        if(root == null) return parent;
        int value = root.val;

        ArrayList<Integer> list = new ArrayList<>();

        int ol = maxTill(root.left, 0);
        list.add(ol);

        int lr = maxTill(root.left, value);
        list.add(lr);


        int pl = maxTill(root.left, value + parent);
        list.add(pl);
        
        int or = maxTill(root.right, 0);
        list.add(or);
        
        int rr = maxTill(root.right, value);
        list.add(rr);
        
        
        int pr = maxTill(root.right, value + parent);
        list.add(pr);
        
        int lrr = lr + rr - value;
        list.add(lrr);
        list.add(value);

        System.out.println(list);

        return Collections.max(list);
        


        
    }
}
