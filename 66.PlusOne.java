class Solution {
    public int[] plusOne(int[] digits) {
        /*
            Approach : O(n)
                The numbers can range from 0 to 9 : 
                    for 0-8 simply increment and return the number.
                    for 9 change that digit to 0 and increment next
                Work on the one's digit or from the end of array.

                If all the elements are Nine then we will return a new array with +1 size of original array and only the first element will be 1 and all will be zero by default.

        */
        int n = digits.length;
        for(int i=n-1;i>=0;i--){
            //When the digits are other than 9
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            //When the digit is 9 
            digits[i]=0;
        }
        //When all digits are 9 the above array will be complete 0
        //New array with +1 size of original array
        int[] ans = new int[n+1];
        ans[0]=1;
        return ans;
    }
}
