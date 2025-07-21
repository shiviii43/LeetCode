class Solution {
    public int maxAscendingSum(int[] nums) {
        /*
            Approach : 
                1.Make two variables curSum and maxSum and initialize them with the value at first index.
                2.Traverse the array from index 1 and compare if the current element is greater than the previous element or not.
                3.If the current element is maintaining the sequence then add its value to the current sum, and keep repeat until the sequence is broken or the array is completely traversed.
                4.If the sequence is broken, check if the max sum is greater than the current sum, if not update them.

        */
        int max = nums[0];
        int currmax = nums[0];

        for(int i=1 ; i<nums.length;i++){
            if(nums[i-1]<nums[i]){
                currmax = currmax + nums[i];
            }else {
                max = Math.max(max , currmax);
                currmax = nums[i];
            }
        }
         max = Math.max(max , currmax);
         return max ;
    }
}
