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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode s = head;
        while(s!=null){
            s = s.next;
            size++;
        }

        int m = size - n + 1;

        if(m == 1){
            return head.next;
        }
        ListNode t = head;
        ListNode prev = head;
        while(t!=null && m>1){
            prev = t;
            t = t.next;
            m--;
        }

        prev.next = t.next;
        return head;



    }
}
