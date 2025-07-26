class Solution {
    public int findMin(int[] nums) {
        /*  
            First lets handle the edge cases such as:
            a.If there is only a single element in the array.
            b.If the rotated array return to it's original state.
            
            Approach 1 :  O(n) time complexity
            Since the array is sorted and then rotated, we can find the smallest element through either of two ways, they are : 
            1.Every element has a greater number at their right, except the smallest -1 element.
            2.Every element has a smaller number at their left, except the smallest element.

            But for this we need to traverse the complete array, so the time complexity is O(n).

            Approach 2 :  O(log n) time complexity 
            Use Binary Search and the array will be divided into two part, there will always be a sorted part and the sorted part will never consist of the minimum element so skip it.



        */

        if(nums.length==1){
           return nums[0];
       }else if ( nums[0]<nums[nums.length-1]){
           return nums[0];
       }

       int start = 0 ;
       int end = nums.length-1 ;

       while(start<=end){
           int mid = (start + end )/2;

           if(mid!=0 && nums[mid-1]>nums[mid]){
               return nums[mid];
           }else if( mid!=nums.length-1 && nums[mid]>nums[mid+1] ){
               return nums[mid+1];
           }else if(nums[start]<=nums[mid]){ // left part is sorted
             start = mid+1 ;
           }else{ // right part is sorted ;
                end = mid-1 ;
           }
       }
       return -1 ; 
        
    }
}
