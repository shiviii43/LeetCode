class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            //If the mid value is equal to the target
            if(nums[mid]==target)
            {
                return mid;
            }
            //Find out which part of the array is sorted
            //Starting from the left part
            else if(nums[low]<=nums[mid]){
                //Means the left part is sorted 
                //Check if the target is in the range or not
                if(target>=nums[low] && target<nums[mid]){
                    //It exists in this sorted array 
                    high = mid-1;
                }
                //It does not exist in this array 
                else{
                    low = mid+1;
                }
            }
            //Means the second part is sorted
            else{
                //Check if the target is in range or not 
                if(target>nums[mid] && target<=nums[high]){
                    //It is in range 
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }

        }
        return -1;
    }
}
