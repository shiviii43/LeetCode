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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /*
          Use Two pointers to find the mid element for a given LL.
          Create a new TreeNode for the next of slow pointer.
          Now for the left of the root element simply call the same function from head till the slow pointer.
          For the right of the root element call the same function from the slow->next->next till the last node.
    */
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return new TreeNode(head.val);
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        TreeNode ansRoot = new TreeNode(slow.next.val);
        ListNode rightPart = slow.next.next;
        slow.next=null;
        ansRoot.left = sortedListToBST(head);
        ansRoot.right = sortedListToBST(rightPart);
        return ansRoot;
    }
}
