class Solution {
    public String removeDuplicateLetters(String s) {
        /*
            Approach : 
            1.Create an array that keeps track of the last index at which a character has appeared.
            2.Create a boolean array that keeps the track of elements present in the stack.
            3.Create a stack and insert element in it.
            4.If the element at top is smaller than the upcoming element then simply insert the new element. 
            Eg. If top is 'a' and 'c' arrives then simply insert c.
            5.If the element at top is larger than the upcoming element then check if the top element will still occur in the string or not, if it occurs late in the string then remove it, else insert the smaller element.
            Eg. If the top is 'c' and 'a' arrives then check which is the last occuring index of 'c', if it is greater than a then remove 'c' and insert 'a', else insert 'a' without any removal.
            6.Maintain the boolean array accordingly.
            7.Atlast return the reverse of the poped characters.

        */

        //Array that keeps the track of  last occurance of character
        int[] lastIndex = new int[26];

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int idx = (int)(ch-'a');

            lastIndex[idx]= i ;
        }

        boolean[] present = new boolean[26];

        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){
              char ch = s.charAt(i);
            int idx = (int)(ch-'a');

            if(present[idx]==false){
                while(st.size()>0 && st.peek()>ch && lastIndex[(int)(st.peek()-'a')]>i){
                    present[(int)(st.peek()-'a')]=false;
                    st.pop();
                }

                st.push(ch);
                present[idx]=true ;
            }
        }

        StringBuilder sb = new StringBuilder("");

        while(st.size()>0){
            sb.append(st.pop());
        }

        return sb.reverse().toString();

    }
}
