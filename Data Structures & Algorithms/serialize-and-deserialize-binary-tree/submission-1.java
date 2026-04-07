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

public class Codec {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque();
        StringBuilder sb = new StringBuilder();

        if(root == null){
            return "n";
        }

        dq.addLast(root);

        while(!dq.isEmpty()){
            TreeNode temp = dq.removeFirst();

            if(temp.val == -10001 ){
                sb.append("n");
                sb.append("|");
            } else {
                sb.append(Integer.toString(temp.val));
                sb.append("|");

                if(temp.left == null) {
                    dq.addLast(new TreeNode(-10001));
                } else {
                    dq.addLast(temp.left);
                }

                if(temp.right == null) {
                    dq.addLast(new TreeNode(-10001));
                } else {
                    dq.addLast(temp.right);
                }
            }
        }

        System.out.println(sb.toString());
        return sb.toString();
        
        
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data.equals("n")) return null;

        String[] nodes = data.split("\\|");
        // remove trailing empty string if any
        int len = nodes.length;
        if (len > 0 && nodes[len - 1].isEmpty()) {
            len--; // ignore last empty
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        int i = 1;

        while (!dq.isEmpty() && i < len) {
            TreeNode current = dq.poll();

            // left child
            if (!nodes[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                current.left = left;
                dq.add(left);
            }
            i++;
            if (i >= len) break;

            // right child
            if (!nodes[i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                current.right = right;
                dq.add(right);
            }
            i++;
        }

        return root;
    
    }

    public TreeNode ct(int i, int n, String nodes[]){
        if(i >= n){
            return null;
        }

        if(getNum(nodes[i]) == null){
            return null;
        }

        TreeNode ans = new TreeNode(getNum(nodes[i]).intValue());
        ans.left = ct(i*2 + 1 , n, nodes);
        ans.right = ct(i*2 + 2 , n, nodes);

        return ans;
    }

    public Integer getNum(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return null; // now valid, because Integer is an object
        }
    }
}
