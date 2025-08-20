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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /*
            Approach : 
            *Dummy Pointer Approach*
            1.Create three pointers p1, p2 and d.
            2.The p1 points the head of the first LL and p2 points the head of the Second LL.
            3.The third pointer d(Dummy) points to a garbage value, this d pointer is used to create the answer linkedList.
            4.We have to iterate until one of the LL is empty.
            5.Pick the smaller one from the p1 and p2 and make the dummy pointer point it, after this move the dummy pointer one step.
            6.If one LL finishes and the other one still remains then simply point the value of p1/p2 by the dummy pointer and it will add the remaining list into the answer list.
            7.At starting copy the dummy pointer into another pointer, and return the next of that pointer as the answer since that pointer will curently store a garbage value then next value as the head of the answer LL.

        */
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode d = new ListNode(-1);
        ListNode ans = d;

        //Iterate until one of the LL is completed
        while(p1!=null && p2!=null){
            //point the smaller one by the dummy
            if(p1.val<p2.val){
                d.next=p1;
                p1=p1.next;
            }
            else{
                d.next=p2;
                p2=p2.next;
            }
            d=d.next;
        }
        //One of the LL is empty 
        if(p1==null){
            d.next=p2;
        }
        else{
            d.next=p1;
        }
        return ans.next;
    }
}
