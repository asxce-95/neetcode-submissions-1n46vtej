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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode prev = new ListNode();
        ListNode t = new ListNode();
        ListNode temp = new ListNode();

        if(l1 == null)
            return l2;

        if(l2 == null)
            return l1;

        if(l2.val < l1.val){
            temp = l1;
            l1 = l2;
            l2 = temp;
        }

        ListNode ans = new ListNode();
        ans =l1;

        while(l1!=null && l2!=null){

            if(l2.val >= l1.val){
                prev = l1;
                l1 = l1.next;
                continue;
            } else {
                t = l2;
                l2 = l2.next;
                t.next = l1;
                prev.next = t;
                prev = t;
            }

        }

        if(l2!=null){

            prev.next = l2;

        }

        return ans;
        
    }
}