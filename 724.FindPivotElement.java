class Solution {
    public int pivotIndex(int[] nums) {
        /*
            Brute Force : O(n*n) and O(1)
            1.Run a loop from the start of the array to the end.
            2.Inside the above loop create two loops : 
                a.A loop that finds the left sum or the sum from 0th index till i-1.
                b.A loop that finds the right sum or the sum from the i+1 th element till the size-1 element.
            3.Stop the main loop once both these sum are equal, if the array is ended and these sum are never found equal then return -1 indicating that the pivot does not exist.

            Approach 2 : 
            *Time Complexity : O(n)*
            *Space Complexity : O(2n)*
            1.Create a prefix array or an array that store the sum of all left elements till a certain element.
            2.Similarly create a suffix array that stores the sum of all the right element till a certain element.
            Eg : array = [1,2,3]
                prefix = [1,3,6]
                suffix = [6,5,3]
            3.Once both the array are formed, traverse both the arrays using a single iterator and check at which index both the arrays contists of the same element, return it.
            4.If no element was found return -1.

            Approach 3 : 
            *Time Complexity : O(n)*
            *Space Complexity : O(n)*
            This approach is the same as the second approach just he difference is that instead of using a left array use a variable to keep track of the left sum.
        Code:
        int n=nums.length;
        //Creating a right sum array 
        int[] rightSum = new int[n];
        rightSum[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            rightSum[i]=rightSum[i+1]+nums[i];
        }
        int leftSum=0;
        for(int i=0;i<n-1;i++){
            if(leftSum==rightSum[i+1]){
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;

            Optimized Approach 4 : 
            *Time Complexity : O(n)*
            *Space Complexity : O(1)*
            1.Use a variable to keep the track of left sum.
            2.Similarly, use a variable to store right sum which will be initially equal to the sum of array.
            3.At each index first update the right sum as rightSum-ele and then compare and after it update the left sum as leftSum+ele.

        */
        int leftSum = 0;
        int rightSum = 0;
        for(int i=0;i<nums.length;i++){
            rightSum+=nums[i];
        }
        //Initially the rightSum will be the sum of the whole array.
        for(int i=0;i<nums.length;i++){
            rightSum-=nums[i];
            if(leftSum==rightSum){
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }
}
