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
    public ListNode deleteMiddle(ListNode head) {
        /*
            Approach :
            1.Find the mid element of the linked list.
            2.Keep the track of the prev of the mid node.
            3.Make modifications using the prev node.


        */
        if(head.next==null) return null;
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=slow;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=slow.next;
        return head;
    }
}
