import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
    /*
        Approach :  O(n) [] 
            1.Create a Stack of Characters.
            2.For every opening parenthesis, simply insert its corresponding closing parenthesis into the stack.
            3.If the stack is empty or the current character is not equal to the poped character then simply return false.
            4.At last check if stack is empty, if yes return true else false.
        Another approach : 
            1.Use the contains function and check if the string contains a pair of opening and closing parenthesis, if yes replace with nothing("")
            2.Continue this until the string in completly traversed.
            3.Check if the string is empty, if yes return true else false.

    */
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
		    if (c == '(')
			    stack.push(')');
		    else if (c == '{')
		    	stack.push('}');
		    else if (c == '[')
		    	stack.push(']');
		    else if (stack.isEmpty() || stack.pop() != c)
		    	return false;
	    }
	    return stack.isEmpty();  
    }
}
