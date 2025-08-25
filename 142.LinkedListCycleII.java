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
    public ListNode detectCycle(ListNode head) {
        /*
            Approach :    Hare-Tortoise(Floyd's Algorithm)
            TC:O(n)
            SC:O(1)
            1.First find out whether there exists a loop in the LL or not, for this simply use the Fast and Slow Pointers.
            2.If there exists a loop in the LL then we have to find the point of the creation of loop.
            3.To find this simply use another pointer from the head and equally increment the slow and the new pointer, at the point where they meet we have out creation point of loop.
            4.If there is no loop then simply return null.
        */
        
        ListNode slow=head;
        ListNode fast=head;
        boolean loopExists = false;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                loopExists=true;
                break;
            }
        }
        if(loopExists){
            slow=head;
            while(slow!=fast){
                slow=slow.next;
                fast=fast.next;
            }
            return slow;
        }
        return null;

    }
}
