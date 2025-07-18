class Solution {
    public int removeElement(int[] nums, int val) {
        /*  CONCEPT 1 [not accurate for all test cases]

        Approach : 
            Create two pointers which are at start and end of the array.
            If the end of the array is equal to val then decrement end pointer.
            Else if the start of array is equal to val then swap with the end and ultimately increment start pointer.
            At last return end+1.
            (Not suitable when the array consists of just 1 element)

        int start = 0;
        int end = nums.length-1;
        while(start<end){
            if(nums[end]==val){
                end--;
            }
            else{
                if(nums[start]==val){
                    int temp = nums[start];
                    nums[start] = nums[end];
                    nums[end]=temp;
                }
                start++;
            }
        }
        return end+1;
        */
        //Optimised Approach
        //Use a pointer to keep track of the valid array and traverse the array.
        //if a valid element is found then swap it with the element at pointer.
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=val){
                int temp = nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
            }
        }
        return i;
    }
}
