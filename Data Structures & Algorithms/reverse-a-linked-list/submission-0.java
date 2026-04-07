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
        ListNode t1 = new ListNode();
        ListNode t2 = new ListNode();
        ListNode t3 = new ListNode();
        prev = null;

        t1 =head;
        t2 =head;
        t3 =head;


        
        while(t1 != null){

            System.out.print(t1.val + " ");
            t1 = t1.next;
        }

        System.out.println();


        while(head != null){

            

            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;

            t1 = head;


        System.out.println();
            while(t1 != null){

                System.out.print(t1.val + " ");
                t1 = t1.next;
            }

        System.out.println();

            t1 = prev;

            while(t1 != null){

                System.out.print(t1.val + " ");
                t1 = t1.next;
            }
        }

        return prev;
        
    }
}
