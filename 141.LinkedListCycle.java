/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        /*
            Approach : HASHSET  4ms
            TC:O(n)
            SC:O(n)
            1.Create a HashSet.
            2.Start inserting the nodes into the hashset.
            3.If a node occurs two time then return false.
            4.Else return True.
        //Code :
        HashSet<ListNode> hs = new HashSet<>();
        ListNode t = head;
        while(t!=null){
            if(!hs.add(t)){
                //Already exists => loop 
                return true;
            }
            t=t.next;
        }
        return false;

            Approach 2 : SLOW and FAST Pointer
            1.Start Iterating the LL using two pointers named as slow and fast which are initialy at the head.
            2.The movement of slow and fast is as : 
                slow = moves 1 step 
                fast = moves 2 steps 
            3.If the two pointers meet then there exists a loop in the LL, if the fast pointer reaches null before the slow then there is no loop in the linked list.

        */
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}
