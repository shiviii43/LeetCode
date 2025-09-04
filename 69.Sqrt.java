class Solution {
    public int mySqrt(int x) {
        /*

            Approach 1 :
            Use the inbuilt Square Root method to find the sqrt of x.
            Code : 
            return Math.sqrt(x);

            Brute Force Approach : 
            TC:O(n)
            SC:O(1)
            1.We have to traverse from 1 till n and keep the track of numbers which can be the sqrt of the given number.
            2.If the number multiplied by itself is less than x then there are chances that it could be our answer, one a number whose multplication with itself exceds x we know that there won't be any number which would be the sqrt of x ahead.
            3.Keep the track of the last number that satisfies the condition
            Code : 
            int ans=1;
            for(int i=1;i<=x;i++){
                if(i*i<=x) ans=i;
                else break;
            }
            return ans;

            Approach 2:     *Binary Search*
            TC:O(logn)
            SC:O(1)
            1.The answer lies between the range 1 and x.
            Eg. for x = 25
                The answer will never be greater than 25 
            2.Find the mid and check if the square of mid is less then or equal to x : 
            if yes then we have to traverse the left subarray
            if no then we have to traverse the right subarray
            3.At last out high will be at the answer and the low will be one step ahead of the high which breaks the binary search condition.

        */
        int low=0;
        int high=x;
        while(low<=high){
            int mid = low+(high-low)/2;
            long m = (long) mid*mid;
            if(m==x){
                return mid;
            }
            if(m<x){
                //mid^2<=x means a possible answer, eliminate the left
                low=mid+1;
            }
            else{
                //Not a possible answer so eliminate the right array
                high=mid-1;
            }
        }
        return high;
    }
}
