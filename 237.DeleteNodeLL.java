/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
       /*
            Approach : 
            Since we are not given the predessor of the current node we cannot simply delete that node from the LL through manipulation.

            Hint : How to become another person in the world? Two steps.
                One, change your appearance to whom you want to be.
                Two, kill that person.

            1.Create a pointer temp that points the next node of the current given node.
            2.Copy the value of the temp node into the prev node and then increment both the pointers node and temp.
            3.Keep continuing until the next of temp is null.
            4.When the next of temp is equal to null means that the temp pointer is currently at the last element which we need to copy and delete.
            5.Copy the value at temp into node, and then point the next of node to the next of the temp which is null.

       */
       ListNode temp=node.next;
       while(temp.next!=null){
        node.val=temp.val;
        node=node.next;
        temp=temp.next;
       }
       //For the last and the second last node
       node.val=temp.val;
       node.next=temp.next;
    }
}
