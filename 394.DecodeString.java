class Solution {
    public String decodeString(String s) {
        /*
            Approach : 

            1.Create a stack that will store the String.
            2.Create another stack that will store the numbers.
            3.Traverse the string and push the elements accordingly.
            4.Once a closing bracket is met then pop from the String stack until a starting bracket is met, and store these poped strings.
            5.Pop from the number stack and repeat the current string as many times as the number exists.
            6.After multiplying simply push the whole string back into the String Stack.
            7.Continue this process until the whole string is pushed.

        */

        Stack<Integer> numberStack = new Stack<>();
        Stack<String> mainStack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch>='0' && ch<='9'){ // identifing it is a number
                int num = 0 ;

                while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
                    num = num * 10  + (int)(s.charAt(i)-'0');
                    i++;
                }
                i--; // to maintain the loop variable
                numberStack.push(num);
            }else if ( ch != ']'){
                mainStack.push(ch + "");
            }else { // condition for ']'
                String str = "";
                while(!mainStack.peek().equals("[")){
                    str = mainStack.pop() + str ;
                }
                mainStack.pop();
                int repetationNumber = numberStack.pop();

                StringBuilder sb = new StringBuilder("") ;

                while(repetationNumber>0){
                    sb.append(str);
                    repetationNumber--;
                }

                 mainStack.push(sb.toString());
            }
        }

        StringBuilder ans = new StringBuilder("");

        while(mainStack.size()>0){
            ans.insert(0,mainStack.pop());
        }
        return ans.toString();
    }
}
