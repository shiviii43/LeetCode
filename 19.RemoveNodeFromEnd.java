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
        
        /*
            EDGE CASE: 
            -Deleting the head node of the linked list.

            Approach 1 :    Two Passes
            TC:O(n)
            SC:(1)
            1.Find the Length of the LL.
            2.Set a Target element as Length-n.
            3.Traverse the LL until the target reaches the previous node of the one we want to delete.
            4.Set the current node's next as its next's next.
            5.Return the Head of the current modified LL. 
        
        //Code 1
        int len=0;
        ListNode t = head;
        while(t.next!=null){
            len++;
            t=t.next;
        }
        int target = len-n;
        t=head;
        if(target<0){   //Removing head node
            t=t.next;
            return t;
        }
        while(target!=0){
            target--;
            t=t.next;
        }
        t.next=t.next.next;
        return head;

            Approach 2 : 
            TC:O(n)
            SC:O(1)
            1.Create two pointers fast and slow pointers.
            2.Move the fast pointer n number of nodes forward than the slow pointer.
            3.Now move both the pointers one step ahead until the next of the fast pointer is null.
            4.Once the next of fast is null, our slow pointer stands before the desired node, so manipulate the next of the slow pointer.
        */

        ListNode fast=head;
        ListNode slow=head;
        while(n>0){
            fast=fast.next;
            n--;
        }
        if(fast==null){  //deleting the head node
            return slow.next;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}
