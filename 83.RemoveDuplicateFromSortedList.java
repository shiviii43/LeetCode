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
    public ListNode deleteDuplicates(ListNode head) {
        /*
            Approach : 
            1.Create a Temporay pointer and a Current Pointer.
            2.The current pointer starts from the head and the temporary starts from th next of the head.
            3.Traverse until the temp pointer stores a null value.
            4.Check if the value at cur and temp are distinct, if yes then link the temp node as the next node of current and increment current and temp;
            5.Else simply increment temp.

        */
        //If the list is empty 
        if(head==null){
            return head;
        }
        ListNode cur = head;
        ListNode temp = head.next;
        while(temp!=null){
            if(cur.val!=temp.val){
                cur.next=temp;
                cur=cur.next;
            }
            else if(cur.val==temp.val){
                cur.next=null;
            }
            temp=temp.next;
        }
        return head;
    }
}
