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
    public ListNode reverseList(ListNode head) {

        ListNode temp = new ListNode();
        ListNode prev = new ListNode();
        prev = null;


        while(head != null){
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;



            // System.out.println();
            // while(t1 != null){

            //     System.out.print(t1.val + " ");
            //     t1 = t1.next;
            // }

            // System.out.println();

            // t1 = prev;

            // while(t1 != null){

            //     System.out.print(t1.val + " ");
            //     t1 = t1.next;
            // }
        }

        return prev;
        
    }
}
