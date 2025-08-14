class Solution {
    public int minAddToMakeValid(String s) {
        /*
            STACK Approach :     2ms
            *Time Complexity : O(n)*
            *Space Complexity : O(n)*
            1.Create a Character Stack.
            2.Traverse the String and insert into the Stack.
            3.For an opening bracket PUSH a opening bracket.
            4.For an closing bracket check if : 
                a.Stack is not empty and has a opening on top, POP.
                b.Else PUSH a closing bracket 
            5.After the String is ended, check for the number of element left in the stack, those many changes we need to make.
            6.Return the size of the stack.
        CODE
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                st.push('(');
            }
            else{
                if(!st.isEmpty() && st.peek()=='('){
                    st.pop();
                }
                else{
                    st.push(')');
                }
            }
        }
        return st.size();

            Optimized Approach :    0ms
            *Time Complexity : O(n)*
            *Space Complexity : O(1)*
            1.Create two counters which keeps track of how many opening or closing brackets are required to make it valid.
            2.Traverse the String and check if : 
                a.Opening bracket occurs then increment the number of closing required.
                b.Closing bracket occurs then :
                    i.If closing required are more than 0 then decrement the closing required as we got a closing.
                    ii.Else increment the opening required counter.
            3.At last return the sum of both counters.
        */
        
        int openingRequired=0;
        int closingRequired=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            //opening bracket
            if(ch=='(') closingRequired++;
            else{
                if(closingRequired>0) closingRequired--;
                else openingRequired++;
            }
        }
        return openingRequired+closingRequired;
    }
}
