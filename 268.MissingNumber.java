class Solution {
    public int missingNumber(int[] nums) {
        //Total sum of n numbers 
        int range = nums.length;
        int expectedSum = (range*(range+1))/2;
        //Original sum 
        int originalSum = 0;
        for(int i=0;i<nums.length;i++){
            originalSum+=nums[i];
        }

        return expectedSum-originalSum;
    }
}
