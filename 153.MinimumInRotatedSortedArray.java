class Solution {
    public int findMin(int[] nums) {
        /*  
            First lets handle the edge cases such as:
            a.If there is only a single element in the array.
            b.If the rotated array return to it's original state.
            
            Approach 1 :  O(n) time complexity
            Simply traverse the array from first to last to find out the minimum element in the array.

            *KEY PROPS of the MINIMUM ELEMENT*
            Since the array is sorted and rotated, there are two properties of the minimum element that can be used to identify it: 
            a.The right of each element will be greater than the element except the highest number in the array.
            b.The left of each element will be smaller than the element except the smallest number in the array.

            Optimized Approach : O(log n)
            1.Divide the array into two parts (Binary Search), onr part atleast will be sorted from those two.
            2.The Sorted part will never consist of the minimum element, only the part where the sequence was broken will contain it.
            3.Ignore the sorted part and half the array accordingly.
            4.Find the Minimum using both the Properties and handling the cases where mid is first or the last element.
            5.Return the Minimum element

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
            //When the prev is greater than the current(100>10)
           if(mid!=0 && nums[mid-1]>nums[mid]){
               return nums[mid];
           }
           //When the current is greater than the next(100>10)
           else if( mid!=nums.length-1 && nums[mid]>nums[mid+1] ){
               return nums[mid+1];
           }
           // left part is sorted
           else if(nums[start]<=nums[mid]){
                start = mid+1 ;
           }
           // right part is sorted ;
           else{ 
                end = mid-1 ;
           }
       }
       return -1 ; 
        
    }
}
