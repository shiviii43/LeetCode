class Solution {
    public int maxSubArray(int[] nums) {
        /*
        Approach 1 : O(n*n)
            1.Start a loop that goes from the first element till the last element.
            2.Start another nested loop that goes from the current element till the last of the array.
            3.Calculate the sum of each subarray and compare it with the maxSum, if greater than replace it eith the maxSum.
            4.This way we can find the maximum sum subarray.


        Optimized Approach : O(n)
        **Kadence Algorithm**
        1.Set two variables current sum and a max sum and initialise them with the first value.
        2.Start iterating from the second element and check which will be a greater value: 
            a.The current sum and addition of current element 
            b.Or the current element
        3.If the current sum + element is greater than continue the subarray
        4.Else simply start a new subArray from the current element.
        5.Keep updating the value of maxSum if the current sum is greater than the maxSum.
        6.Continue this process till the last element of array.

        */

        int curSum = nums[0];
        int maxSum = nums[0];
        for(int i=1;i<nums.length;i++){
            curSum+=nums[i];
            if(curSum<nums[i]){
                curSum=nums[i];
            }
            maxSum = Math.max(curSum,maxSum);
        }
        return maxSum;
    }
}
