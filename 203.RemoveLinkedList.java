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
    public ListNode removeElements(ListNode head, int val) {
        /*
            Approach : 
            TC:O(n)
            SC:O(1)
            1.Handle the edge case of List being a null list.
            2.Store the head node and traverse using the temp pointer
            3.Create a previous pointer to keep track of the prev.
            4.If a node has the value as val the simply make link manipulations and remove that node from the LL.

            All this can also be done using just a dummy pointer and a current pointer where we make changes on the condition cur.next==val is yes then we move the pointer as cur.next=cur.next.next
        */
        if(head==null) return null;
        ListNode cur = head;
        ListNode prev = new ListNode(0);
        ListNode ans = prev;
        while(cur!=null){
            if(cur.val==val){
                prev.next=cur.next;
                cur=cur.next;
            }
            else{
                prev.next=cur;
                prev=cur;
                cur=cur.next;
            }
        }
        return ans.next;
    }
}
