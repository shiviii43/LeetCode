class Solution {
    public int singleNonDuplicate(int[] nums) {
        /*
        BRUTE FORCE APPROACH : O(n)
        1.Create a hashtable and insert all the elements of the array.
        2.After all the elements are inserted, traverse the hash table and look for the key which has a frequency of 1.
        3.Return the key as the answer.

        *Another approach*
        Use two pointers from index 2 till size-3 and move those two pointers with comparision and checking for elements which are same.

    */
        //OPTIMIZED APPROACH : O(log n)
        if(nums.length==1) return nums[0];

        else if ( nums[0]!=nums[1]) return nums[0];
        else if ( nums[nums.length-1] != nums[nums.length-2]) return nums[nums.length-1];

        int start = 0 ;
        int end = nums.length-1 ;

        while(start<=end){
            int mid = (start + end)/2;

            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }
            else if ( mid % 2 ==1 ){ // if mid index is odd

                if(nums[mid-1]==nums[mid]){
                    start = mid+1 ;
                }else{
                    end = mid-1 ;
                }
            }
            else { // if mid index is even
                    if(nums[mid]==nums[mid+1]){
                        start = mid +1 ;
                    }else{
                        end = mid -1 ;
                    }
            }
        }

        return -1 ;
    }
}
