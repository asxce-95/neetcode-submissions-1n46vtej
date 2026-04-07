/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode hop1 = head;
        ListNode hop2 = head; 

        if(head!=null && head.next!=null && head.next.next != null){
            hop2 = head.next.next;
        } else {
            return false;
        }


        while(hop2!=null && hop2.next !=null && hop2.next.next != null && hop1!=null){


            if(hop1.val == hop2.val){
                return true;
            }
            hop1 = hop1.next;
            hop2 = hop2.next.next;

        }

        return false;
        
    }
}
