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
    public boolean isPalindrome(ListNode head) {
        /*
            Approach 1 :
            TC - O(n)     SC - O(n)  
            1.Traverse the linked list from starting to ending and store the integer values into a Integer List.
            2.Now for the ArrayList simply use Two Pointers and start the comparision from the start and the end of the List.
            3.If Two elements are found distinct then return false.

        ArrayList<Integer> li = new ArrayList<>();
        while(head!=null){
            li.add(head.val);
            head=head.next;
        }
        int sp=0;
        int lp=li.size()-1;
        while(sp<=lp){
            if(li.get(sp)!=li.get(lp)){
                return false;
            }
            sp++;
            lp--;
        }
        return true;

        Approach 2 : *Stacks*
        TC - O(n)      SC - O(n)
        1.Traverse the LinkedList and keep inserting the elements into the stack.
        2.Traverse the Linked List element by element and at the same time POP from the stack and compare both the elements, if any element is different then return false.
        3.Continue this until either the Stack is empty or the LL.
        [Since the Stack return in reverse we are simply comparing the original number sequence with its reverse ]

        Optimized Approach :
        TC - O(n)      SC - O(1)
        1.We need to find the mid element of the linked list so we will use the concept of slow and fast pointer to attain that.
        2.Now that we know the mid element, reverse the second half of the Linked List.
        3.Now use two pointers one from the first element of the first half and second from the first element of the second half.
        4.Keep comparing the elements of the two halfs, if any element exists which is not corresponding, then return false.

        */

        ListNode slow = head, fast = head, prev, temp;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        prev = slow;
        slow = slow.next;
        prev.next = null;
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        fast = head;
        slow = prev;
        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}
