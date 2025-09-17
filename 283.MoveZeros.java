class Solution {
    public void moveZeroes(int[] nums) {
        /*
        Approach : 
            Use Two Pointers to keep track of the current zero and non zero element in the array.
            If the p1 pointer is not zero then simply increment both the pointers, if the p1 has a zero then check for the value at the second pointer, if it has a zero as well then increment the second pointer.
            If the second pointer has a non zero element then simply swap the value at the p1 with the value at the p2 and increment both the pointers.
        
        */
        int p1 = 0;
        int p2 = 1;
        while(p2<nums.length){
            //When p1 has 0
            if(nums[p1]==0){
                //Where p2 is non zero
                if(nums[p2]!=0){
                    int temp=nums[p1];
                    nums[p1]=nums[p2];
                    nums[p2]=temp;
                    p1++;
                }
            }
            //When p1 does not have zero
            else{
                p1++;
            }
            p2++;
        }
    }
}
