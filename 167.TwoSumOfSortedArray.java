class Solution {
    public int[] twoSum(int[] numbers, int target) {
        /* 
            Brute Force Approach:   O(n*n)
                Use two loops, one to traverse the array and another to multiply the current element with the other elements in the array to reach goal.
                Once you reach the solution break out from the loops.
            Optimized Solution: O(n)
                **TWO POINTER**
                Create a start pointer and a end pointer pointing the starting element and the ending element of the array respectively.
                Create a loop until the start is less than the end pointer.
                Add the value at start and end then compare with the target.
                If the target is smaller meaning that we need to decrease our value, so we will decrement the end pointer. [Sorted array]
                If the target is larger meaning that we need to increase our value, so we will increment the start pointer. [Sorted array]

        */
        int start = 0;
        int end = numbers.length-1;

        while(start<end){
            int sum = numbers[start]+numbers[end];
            if(sum==target){
                start++;
                end++;
                return new int[]{start,end};
            }
            else if(sum<target){
                start++;
            }
            else{
                end--;
            }
        }
        return new int[]{};
    }
}
