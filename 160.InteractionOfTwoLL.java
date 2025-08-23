/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /*
            Edge case : If any LL is empty then there will be no intersection between them.

            Approach 1 : HASHSET
            Time Complexity : O(n) *Two loops*
            Space Complexity : O(len(L1)+len(L2))
            1.Create a HashSet.
            2.Insert the nodes of the first LL into the HashSet.
            3.Now Insert the nodes of the second LL into the HashSet, if any value already exists then the add method will return false, that value will be the intersection point.

        //Code 
        HashSet<ListNode> hs = new HashSet<>();
        ListNode t = headA;
        while(t!=null){
            hs.add(t);
            t=t.next;
        }
        t=headB;
        while(t!=null){
            if(!hs.add(t)){
                return t;
            }
            t=t.next;
        }
        return null;
             
            Approach 2 : TWO POINTERS
            Time Complexity : O(n)
            Space Complexity : O(1)
            1.We need to check if corresonding elements of both the LL are equal, but both the LL can be of different lengths.
            2.Make both the LL equal in length by finding the lengths of the LL and crop the longer list.
            3.Once both the List are equal in length then simply use two pointers and check for corresponding nodes of the LL.

        */

        if(headA==null || headB==null) return null;

        int size1 = lengthLL(headA);
        int size2 = lengthLL(headB);
        int dif = size1-size2;
        ListNode ptr1 = headA;
        ListNode ptr2 = headB;
        if(dif<0){//Size2>Size1
            while(dif<0){
                ptr2=ptr2.next;
                dif++;
            }
        }
        else{//Size1>Size2
            while(dif>0){
                ptr1=ptr1.next;
                dif--;
            }
        }
        //Both list are equal in length 
        while(ptr1!=null){
            if(ptr1==ptr2){
                return ptr1;
            }
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        return null;
    }
    public int lengthLL(ListNode head){
        int count=0;
        while(head!=null){
            head=head.next;
            count++;
        }
        return count;
    }
}
