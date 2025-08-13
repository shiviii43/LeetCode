class Solution {
    public boolean isPalindrome(String s) {
        /*
            Approach :
            *Time Complexity : O(n)*
            *Space Complexity : O(n)*
            1.A string with only 1 character will always be true.
            2.Create a StringBuilder instance.
            3.In the StringBuilder instance insert the characters from the string, only if the characters are alphanumeric.
            4.Now that all the characters are inserted we only need to check if the string is a palindrome or not.
            5.To do it simply traverse the string using two pointers.

        */
        
        if(s.length()==1){
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            //For lower case characters
            if(ch>='a' && ch<='z'){
                sb.append(ch);
            }
            //For upper case characters
            else if(ch>='A' && ch<='Z'){
                //B-A => 1 + a => b
                ch = (char)(ch-'A'+'a');
                sb.append(ch);
            }
            //Numeric values
            else if(ch>='0' && ch<='9'){
                sb.append(ch);
            }
        }
        //Checking for palindrome
        int start=0;
        int end=sb.length()-1;
        while(start<end){
            if(sb.charAt(start)!=sb.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
