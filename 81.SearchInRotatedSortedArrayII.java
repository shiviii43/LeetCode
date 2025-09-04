class Solution {
    public boolean search(int[] nums, int target) {
        /*
            Approach : 
            TC: O()
            SC: O()
            Use binary search and the array will be divided into two parts one will be sorted and another will be an unsorted array.
            Find the Sorted AubArray and search accordingly
            For the duplicate elements : 
            if(nums[start]==nums[mid] && nums[mid]==nums[end]){
                start+=1;
                end-=1;
                continue;
            }
        */
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]==target){
                return true;
            }
            //Reducing duplicate elements
            if(nums[start]==nums[mid] && nums[mid]==nums[end]){
                start+=1;
                end-=1;
                continue;
            }
            //The left part of the Array is sorted
            if(nums[start]<=nums[mid]){
                //Checking if the number exists in the sorted part
                if(target>=nums[start]&&target<=nums[mid]){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            //The right part of the Array is sorted
            else{
                if(target>=nums[mid]&&target<=nums[end]){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
        }
        return false;
    }
}
