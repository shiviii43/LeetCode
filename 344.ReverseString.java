class Solution {
    public void reverseString(char[] s) {
        /*
            Brute Force Approach : 
            TC:O(n)
            SC:O(n)
            1.Create a new char array of n size.
            2.Traverse the current array from the end to the start and insert the elements from the array into the new array.
            3.return the new array as the answer.

            Optimized Approach :
            TC:O(logn)
            SC:O(1)
            1.Create Two Pointers and keep them at the start and end.
            2.Swap the values at the start and end.
            3.Increment the start and decrement the end pointer.
            4.Traverse them until they are equal or start is smaller.
        */
        
        int start = 0;
        int end = s.length-1;
        while(start<=end){
            char t = s[start];
            s[start] = s[end];
            s[end] = t;
            start++;
            end--;
        }
    }
}
