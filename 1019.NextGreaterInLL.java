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
    public int[] nextLargerNodes(ListNode head) {
        /*
            Approach : 
            1.Create an ArrayList and insert all the elements into it
            2.Find out the size of the ArrayList and then create an answer array using that size.
            3.Create a Stack that stores the maximum number.
            4.For every element check for the element in the stack :
                If the stack is empty then insert zero.
                If the stack contains a number which is smaller than the current number then pop it and insert the number into the stack after adding 0 to our resulting array.

        */
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        
        int n = values.size();
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && values.get(stack.peek()) < values.get(i)) {
                answer[stack.peek()] = values.get(i);
                stack.pop();
            }
            stack.add(i);
        }
        return answer;
    }
}
