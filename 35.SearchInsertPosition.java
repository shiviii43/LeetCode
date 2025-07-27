class Solution {
    public int searchInsert(int[] nums, int target) {
        /*
            APPROACH : 
            Use binary search to find the element
            If the mid is equal to the target simply return the mid.
            If the element does not exist in the array then the loop will break with start pointer at the location where it should have been present.
            
        */
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) end=mid-1;
            else start=mid+1;
        }
        //If the element was not present in the array
        return start;
    }
}
