class Solution {
    public int[] sortedSquares(int[] nums) {
        /*
        Brute force approach O(nlog(n))
            Use a loop to traverse the array and replace the elements with their squares.
            Sort the array using sorting technique.

        Optimised Approach O(n)
            ** TWO POINTER **
            Since the array is sorted, either the minimum or the maximum element of the array will produce the highest square for the new array.
            Use two pointers at start and end for finding out the greater square and start inserting into the new array from the end.   
        */

        int start = 0;      //Start Pointer 
        int end = nums.length-1;        //End Pointer
        int[] ans = new int[nums.length];     //Answer Array
        int tp = ans.length-1;           //Third pointer 

        while(start<=end){
            //Calculate the sqaure of element at start and end.
            int ss = nums[start]*nums[start];
            int es = nums[end]*nums[end];
            if(ss>es){
                ans[tp] = ss;
                start++;
            }
            else{
                ans[tp] = es;
                end--;
            }
            tp--;
        }
        return ans;
    }
}
