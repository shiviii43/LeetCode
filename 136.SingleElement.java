class Solution {
    public int singleNumber(int[] nums) {
        /*
            Brute Force Approach : 
            Time complexity : O(n*n)
            Space Complexity : O(1)

            1.Start a loop from the first element till the last.
            2.Start another nested loop that finds a similar element in the remaining array.
            3.If there exists a similar element then simply traverse to the next element else if its doesn't then return the number.

            HASH : 
            Time Complexity : O(n)
            Space Complexity : O(n)

            1.Traverse the array and insert all the elements and their frequency in a HashMap.
            2.In the HashMap search for a key which has a frequency of 1 and return it as the answer.

            BIT MANIPULATION : 
            Time Complexity : O(n)
            Space Complexity : O(1)

            1.We know that XOR of similar bits result to 0 and distinct bits result to 1.
            2.XOR of 2 and 2 will give us 0 and 0 and 1 will give us 1 as the answer.
            3.XORing the whole array, element by element will result us in a variable consisting of the single number.

            Eg: 
            nums = [4,1,2,1,2]
            a.4^1 = 100^001 = 101 = 5
            b.5^2 = 101^010 = 111 = 7
            c.7^1 = 111^001 = 110 = 6
            d.6^2 = 110^010 = 100 = 4
            
            ans = 4

        */

        int val = nums[0];
        for(int i=1;i<nums.length;i++){
            val^=nums[i];
        }
        return val;
    }
}
