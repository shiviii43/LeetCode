class Solution {
    public int lengthOfLastWord(String s) {
        /*
            Approach : O(n) 
            1.Traverse the string from the end.
            2.Find the first occurance of a charcter.
            3.Traverse the string from that occurance till a space or ' ' is found.

        */
        int len=0;
        int i=s.length()-1;
        //Finding the first occurance of any character
        while(i>=0 && s.charAt(i)==' '){
            i--;
        }
        //Calculating the length of the last character found
        while(i>=0 && s.charAt(i)!=' '){
            len++;
            i--;
        }
        return len;
    }
}
