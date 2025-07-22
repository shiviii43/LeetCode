class Solution {
    public int search(int[] nums, int target) {
        /*Approach : 
            1.Create a mid element that consist of the (start+end)/2.
            2.Check if the mid element is equal to the target, if yes return mid as the index of the element found.
            3.If the mid element is greater than the target element then it certainly means that the target belongs to the right subarray.
            4.If the mid element if less than the target element then the target element belongs to the left subArray.
            5.Change the value of start and end accordingly.
        */
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            //If our mid is equal to the target element
            if(nums[mid]==target){
                return mid;
            }
            //if mid is less than the target then switch to right subarray
            else if(nums[mid]<target){
                start = mid+1;
            }
            //Else switch to the left Subarray 
            else{ 
                end = mid-1;
            }
        }
        return -1;
    }
}
