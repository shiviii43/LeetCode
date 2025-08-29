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
    
    public ListNode mergeKLists(ListNode[] lists) {
        /*
            EDGE CASES : 
            Only one element in the list -> return that list 
            No element in the list -> return null

            Approach 1 : 
            *Divide and Conquer*
            1.Make a function that merges two sorted LL and return the head of the new merged LL.
            2.Call the above function for two list first then move ahead till we finish our list.
            3.For each merged list call the function again for the next LL.


        //Code
        public ListNode mergeLL(ListNode h1,ListNode h2){
        ListNode p1 = h1;
        ListNode p2 = h2;
        ListNode d = new ListNode(0);
        ListNode ans = d;
        while(p1!=null && p2!=null){
            if(p1.val<p2.val){
                d.next=p1;
                d=d.next;
                p1=p1.next;
            }
            else{
                d.next=p2;
                d=d.next;
                p2=p2.next;
            }
        }
        if(p1!=null){
            d.next=p1;
        }
        else{
            d.next=p2;
        }
        return ans.next;
    }
        //Inside the main method
        if(lists.length==0) return null;
        if(lists.length==1) return lists[0];
        ListNode ans=mergeLL(lists[0],lists[1]);
        //Start traversing from the second index of the list
        for(int i=2;i<lists.length;i++){
            ListNode h = lists[i];
            ans = mergeLL(ans,h);
        }
        return ans;

            Approach 2 : 
            *HEAP or Priority Queue*
            1.Make a Priority Queue with objects(Comparator).
            2.Traverse the List from 0 till the last element.
            3.For each element which is a head of a LL, keep inserting nodes until a null is reached in each LL.
            4.Now that all the elements are inserted in the Heap DS, make a Dummy Pointer and 

        */

        
    }
}
