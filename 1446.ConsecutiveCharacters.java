class Solution {
    public int maxPower(String s) {
        /*
          Approach : 
          * Time Complexity : O(n)*
          *Space Complexity : O(1)*
          1.Start from the second character and compare it with its previous element.
          2.If the element is same as the previous element then increment the current sequence count.
          3.Else if the element is not the same as the previous element then restart the current sequence count from 1.
          4.After each element update the max count.

        */
        int max = 1;
        int cur = 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                cur+=1;
            }
            else{
                cur=1;
            }
            max = Math.max(max,cur);
        }
        return max;
    }
}
