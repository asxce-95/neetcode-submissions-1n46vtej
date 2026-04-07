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
    public void reorderList(ListNode head) {

        ListNode t1 = new ListNode();

        ListNode t = head;

        //Get Size
        int n = 0;
        while(t != null){
            n++;
            t = t.next;
        }

        //get mid
        int mid = 1 + n/2;

        //Cut the list
        ListNode l2 = head;
        ListNode prev = head;

        while(mid > 0){
            prev = l2;
            l2 = l2.next;
            mid--;
        }

        //cut
        prev.next = null;

        //revese l2
        l2 = reverseList(l2);

        t = head;

                
        t1 = head;


        
        while(t1 != null){

            System.out.print(t1.val + " ");
            t1 = t1.next;
        }

        System.out.println();
        System.out.println();
        t1 = l2;


        
        while(t1 != null){

            System.out.print(t1.val + " ");
            t1 = t1.next;
        }

        System.out.println();
        System.out.println();

        t1 = l2;

        while(t1 != null){

            System.out.print(t1.val + " ");
            t1 = t1.next;
        }

        System.out.println();

        while(l2!=null){
            ListNode temp = l2;
            l2 = l2.next;
            temp.next = t.next;
            t.next = temp;
            t = temp.next;

        }
    }

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
