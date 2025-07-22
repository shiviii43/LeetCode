class Solution {
    public int[] searchRange(int[] nums, int target) {
        /*
            Approach 1 : O(n)
            Using Two Pointers, create two pointers start and end.
            When the start pointer reaches the target, stop and store it.
            Do same for the end pointer.
            Return the start and the end value inserted in an array.

            Approach 2 : O(log n)
            Use Binary Search to find the first occurance of the element.
            Similarly, find the last occurance of the element.
            Hence, there will be two Binary Searches used for this.
        */

        if(nums.length==0){
            return new int[]{-1,-1};
        }

        int first = -1;
        //Binary Search one 
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            //When found
            if(nums[mid]==target){
                first = mid;
                high = mid-1;
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        int last = -1;
        //second binary search 
        low = 0;
        high = nums.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                last = mid;
                low = mid+1;
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return new int[]{first,last};
    }
}
