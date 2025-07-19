class Solution {
    public int[] productExceptSelf(int[] nums) {
        /* Approach 1 : O(n)
            1. Calculate the total product of the array.
            2. Insert into the new array as product divided by the element at that index in the original array.
            NOTE : runs in O(n) time but uses the division operator.
                    not efficient when working with zero in the array.

            
            Approach 2 : O(n)
            1. Create an array which consist of product of elements from the right side.
            2.Create a varible intially as 1 keeping the track of left sum.
            3.Insert into the new array as (left*right[i+1]) which means the product of elements till i from left multiply by the product of elements from the right side of i.

    */
        int n = nums.length;
        int[] right = new int[n];
        //Calculate the right product array as
        int product = 1;
        for(int i=n-1;i>=0;i--){
            product = product * nums[i];
            right[i] = product;
        }
        //Right Array has been obtained
        
        //Create an Answer array
        int[] ans = new int[n];
        int leftProduct = 1;
        for(int i=0;i<n-1;i++){
            ans[i] = leftProduct*right[i+1];
            //now increase the left product
            leftProduct = leftProduct*nums[i];
        }
        //Handling the last value 
        ans[n-1]=leftProduct;
        return ans;
    }

}
