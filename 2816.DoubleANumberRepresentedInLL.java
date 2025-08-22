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
    
    public ListNode doubleIt(ListNode head) {
        /*
            Approach 1 :    Reverse the LL
            *Similar as the Add two numbers*
            1.Reverse the linked list using 3 pointers which are prev, curr and next.
            Eg. 189 => 981
            2.Now create a carry variable for keeping the track of the carry.
            3.For each value in the new reversed LL simply add that value with itself and the carry variable. Eg. 9 + 9 + 0.
            4.Check if a carry is generated if the sum is greater than 9 then yes, so the sum is sum%10 and the carry is sum/10.
            5.After all this is done the answer will be generated in the reverse order i.e. 873, so reverse the LL again.
            6.For a number 905 there will always be an extra carry, so handle it as 905 => reverse => 509 then after the sum 018 and carry as 1, so we add the carry to the LL which makes it 0181 and then reverse it.
    CODE :
    public ListNode reverseLL(ListNode head){
        //Here we reverse the LL using 3 pointers 
        ListNode prev=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return prev;
    }
        *This is inside the main function*
        head = reverseLL(head);
        int carry=0;
        ListNode d = new ListNode(-1);
        ListNode ans = d;
        while(head!=null){
            int sum=head.val+head.val+carry;
            carry=sum/10;
            sum%=10;
            //We have to insert into the new LL
            ListNode node = new ListNode(sum);
            d.next=node;
            d=d.next;
            head=head.next;
        }
        //If the carry is not zero then add it into the LL
        if(carry>0){
            ListNode node = new ListNode(carry);
            d.next=node;
        }
        //Now again we have to reverse the answer LL
        //Since the ans.next contains the last element we reverse from the ans.next and update the ans 
        ans = reverseLL(ans.next);
        return ans;

            Approach 2 : STACK APPROACH 
            1.Traverse the LL and keep inserting into the Stack.
            2.Start POPING from the stack, and multiply the value by 2 and then add a carry which is initialised by 0.
            3.Update the carry as carry = sum/10.
            4.Update the sum as sum = sum%10.
            5.Create a new LL and keep inserting at the beginning.
            6.At last if the carry>0 then insert the carry as well.
        Code:
        Stack<Integer> st = new Stack<>();
        while(head!=null){
            st.push(head.val);
            head=head.next;
        }
        int carry=0;
        ListNode t = new ListNode(0);
        while(st.size()!=0){
            int val=st.pop();
            int sum = val+val+carry;
            carry=sum/10;
            sum%=10;
            ListNode node = new ListNode(sum);
            node.next=t.next;
            t.next=node;
        }
        if(carry>0){
            ListNode node = new ListNode(carry);
            node.next=t.next;
            t.next=node;
        }
        return t.next;
        */

        //Approach 3 
        if (head.val > 4)
            head = new ListNode(0, head);
        for(ListNode node = head; node != null; node = node.next) {
            node.val = (node.val * 2) % 10;
            if (node.next != null && node.next.val > 4)
                node.val++;
        }
        return head;
    }
}
