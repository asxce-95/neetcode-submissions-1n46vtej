/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/


class Solution {

        HashMap<Integer, Node> m = new HashMap<>();
    
    public Node cloneGraph(Node node) {


        if(node == null)
            return null;

        Node head = new Node();

        Node temp = node;

        Node dup = new Node();

        dup.val = temp.val;
        m.put(dup.val, dup);

        // for(Node curr: temp.neighbors){
        //     dup.neighbors.add(cloneGraph(curr));
        // }

        for(int i=0 ; i<temp.neighbors.size(); i++){
            Node tr = temp.neighbors.get(i);
            if(tr != null){
                if(m.containsKey(tr.val)){
                    dup.neighbors.add(m.get(tr.val));
                } else {
                    dup.neighbors.add(cloneGraph(tr));
                }
                
            }
        }


        return dup;
        
    }
}