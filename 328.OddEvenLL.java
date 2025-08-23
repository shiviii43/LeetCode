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
    public ListNode oddEvenList(ListNode head) {
        /*
            Approach : 
            *Time Complexity : O(n)*
            *Space Complexity : O(1)*
            1.We will create two pointers which are PO and PE which keeps track of previous even and previous odd nodes.
            2.Since we know the first element at head will always be at odd index and the second will be at even we will point our PE and PO accordingly.
            3.We will use a counter variable which starts from 1 and keeps on increasing and we will find even odd on its basis.
            4.To make sure we do not lose our even and odd LL, we will store their starting nodes in head and head2.
            5.Using the counter and a dummy or temp pointer we will traverse the node from the third element and count as 1.
            6.When its odd we will make the PO point the temp and then increment the PO,also when odd remove the link of the PE to avoid getting a loop in LL when the total elements are odd.
            7.Similar process for the even node.
            8.We will now have 2 different LL one odd and one even, we need to link them as odd->even so our PO will point to the head of the even LL.
            9.At last return the head of the Odd linked list.
            [Make sure to handle the edge cases such as EmptyLL, single element and just two elements.]
        */
        
        //Checking for edge cases 
        if(head==null){
            return head;
        }
        else if(head.next==null){
            return head;
        }
        
        ListNode po = head;
        ListNode pe = head.next;
        ListNode head2 = pe;
        ListNode temp = pe.next;
        int counter = 1;
        while(temp!=null){
            //Odd case
            if(counter%2!=0){
                pe.next=null;
                po.next=temp;
                po=po.next;
            }
            //Even Case
            else{
                pe.next=temp;
                pe=pe.next;
            }
            temp=temp.next;
            counter++;
        }
        //Now we have to link the both LL
        po.next=head2;
        return head;
    }
}
