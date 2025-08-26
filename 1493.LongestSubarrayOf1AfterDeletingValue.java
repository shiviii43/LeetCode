class Solution {
    public int longestSubarray(int[] nums) {
        /*
            Approach :
            **Sliding Window**
            TC:O(n)
            SC:O(1)
            1.Create two pointers left and right to keep track of the current window.
            2.Keep the track of the number of zero's in the current window as it must tolerate only a single zero.
            3.Keep incrementing right pointer until there are 2 zero.
            4.Now that we have got two zeros in our window, we will move the left pointer until the number of zeroes are reduced to 1.
            5.Keep updating the result as the max between the max and the current right-left.
            
        */

        int left=0, zeroCount=0, ans=0;
        for(int right=0;right<nums.length;right++){
            //If the current element is zero increase the count
            if(nums[right]==0) zeroCount++;

            //Moving the Left pointer until our window has single 0
            while(zeroCount>1){
                if(nums[left]==0){
                    //We found the zero we want to remove
                    //Break the loop by updating the variable
                    zeroCount--;
                }
                left++;     //We need to increment in both 1 and 0
            }
            //Else simply increment right and update the answer
            ans = Math.max(ans,right-left);
        }
        return ans;
    }
}
