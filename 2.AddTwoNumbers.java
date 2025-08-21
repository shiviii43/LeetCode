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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
            Approach :
            *Somewhere same as the Merge two sorted list*
            1.We will use two pointers and a dummy pointer.
            2.The two pointers are used to keep track of the list from which each element is to be added with the other list.
            3.Keep the track of the carry using a carry variable and add the carry with the two numbers.
            4.Once one LL Pointer reaches null then simply start adding 0 to the remaining elements of the other List.
            5.At the end check for the value of carry, if the carry still exists and both the LL have completed then simply create a node with the value as carry and link it to the dummy pointer.

        */

        //two pointers that points the head of the LL
        ListNode p1=l1;
        ListNode p2=l2;
        //dummy pointer 
        ListNode d = new ListNode(-1);
        ListNode ans = d;
        int carry=0;
        while(p1!=null||p2!=null){
            int n=0;
            if(p1==null){
                n=0+p2.val;
            }
            else if(p2==null){
                n=0+p1.val;
            }
            else{
                n=p1.val+p2.val;
            }
            if(carry!=0){
                n+=carry;
                carry=0;
            }
            //n Stores the sum of the current two pointers
            //Handle the case where n is greater than 9 and has carry
            if(n>9){
                //Meaning the n will create a carry 
                carry=n/10;
                n%=10;
            }
            //Create a node and link it with the dummy
            ListNode temp = new ListNode(n);
            d.next=temp;
            d=d.next;
            //Increment both the pointers as well
            if(p1!=null) p1=p1.next;
            if(p2!=null)p2=p2.next;
        }
        //If both the list have been completed and the carry still stands then add the carry to the answer
        if(carry!=0){
            ListNode t = new ListNode(carry);
            d.next=t;
        }
        return ans.next;
    }
}
