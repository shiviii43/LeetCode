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
    public ListNode mergeNodes(ListNode head) {
        /*
            Approach 1 : 
            1.Start a pointer from the second node and also create a sum variable that stores the sum of integers between two zeroes.
            2.If the current value is not 0 just add that to the current sum and keep traversing the LL.
            3.Once a zero is reached make a new node with the current value of sum, then make the dummy pointer point this new node and restart the sum from 0.
            4.Keep iterating until we reach a null node.
            5.At last return the starting of the dummy LL.

        //Code 
        ListNode t = head.next;
        ListNode d = new ListNode(0);
        ListNode ans = d;
        int sum = 0;
        while(t!=null){
            if(t.val!=0){
                sum+=t.val;
            }
            else{
                ListNode node = new ListNode(sum);
                d.next=node;
                d=d.next;
                sum=0;
            }
            t=t.next;
        }
        return ans.next;
            Approach 2 : 
            Keep a boolean flag to know if we need to : 
                a.Add the element with the current sum.
                b.Make a node of the current sum and refresh it.

            Flag = true => add into sum
            
        */

        ListNode t = head.next;
        ListNode d = new ListNode(0);
        ListNode ans = d;
        boolean flag = true;
        int sum = 0;
        while(t!=null){
            if(t.val==0) flag=false;
            if(flag){
                sum+=t.val;
            }
            else{
                ListNode node = new ListNode(sum);
                d.next=node;
                d=d.next;
                sum=0;
                flag=true;
            }
            t=t.next;
        }
        return ans.next;
    }
}
