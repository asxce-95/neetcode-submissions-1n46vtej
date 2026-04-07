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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ans = l1;
        ListNode prev = l1;
        while(ans != null && l2 != null ){
            int val = ans.val + l2.val + carry;
            int rem = val % 10;
            carry = val / 10;

            ans.val = rem;
            prev = ans;
            ans = ans.next;
            l2 = l2.next;

        }

        while(l2!=null){
            int val = l2.val + carry;
            int rem = val % 10;
            carry = val / 10;
            l2.val = rem;
            prev.next = l2;
            prev = l2;
            l2 = l2.next;
        }

        while(ans!=null){
            int val = ans.val + carry;
            int rem = val % 10;
            carry = val / 10;
            ans.val = rem;
            prev = ans;
            ans = ans.next;
        }

        if(carry > 0){
            prev.next = new ListNode(carry);
        }

        return l1;
        
    }
}
