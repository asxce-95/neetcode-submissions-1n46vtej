/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node h) {

        Node nh = null;
        Node curr = null;
        Node prev = null;
        Node head = h;

        HashMap<Node, Node> m = new HashMap();

        if(head!=null){
            Node temp = new Node(head.val);
            nh = temp;
            m.put(head, temp);
            head = head.next;
            prev = temp;
        } else {
            return nh;
        }
        
        while(head!=null){
            Node temp = new Node(head.val);
            prev.next = temp;
            prev = prev.next;
            
            m.put(head, temp);

            head = head.next;
        }

        curr = nh;


        while(h!=null){

            Node temp = m.get(h.random);
            curr.random = temp;
            h = h.next;
            curr = curr.next;
        }

        return nh;
    }

}
