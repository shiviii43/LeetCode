class Solution {
    public String reverseWords(String s) {
        /*
            Approach : O(n)
                1.Use the split function and store the words in a String array.
                2.Create a StringBuilder instance and in that instance append elements from the String array from the end to start.
                3.The only problem that remains is that after the last element an extra space is left, to remove it : 
                    (a)Either use the trim method that removes the extra space from the starting and ending of a string.
                    (b)Work on substring and store only the substring which does not contain the extra space.

        */

        //Splitting on the basis of space
        String[] arr = s.split("\\s+");
        StringBuilder sb = new StringBuilder("");
        for(int i=arr.length-1;i>=0;i--){
            sb.append(arr[i]+" ");
        }
        //Removing the last space using trim 
        String ans = sb.toString();
        ans = ans.trim();
        return ans;
    }
}
