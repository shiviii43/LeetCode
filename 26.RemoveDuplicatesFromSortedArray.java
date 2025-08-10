class Solution {
    public int removeDuplicates(int[] nums) {
        /*
            Brute Force Approach : 1ms
            *Time Complexity: O(n)*
            *Space Complexity : O(n)*
            1.Create a new array and store the first element of the initial array in it.
            2.Create Two pointers : 
                j which starts from 1 and points the element at index 1 of the initial array
                i which starts from 0 and points to the single element in the new array.
            3.Start a loop that goes until j is greater than the size of the array nums.
            4.Check if the element at j and i are distinct, if yes then increment i and then insert the element at j of nums into the i position of the new array.
            5.Keep incrementing the j pointer.
            6.Atlast return the i pointer as the answer length.
        CODE
        int[] ans = new int[nums.length];
        ans[0]=nums[0];
        int i=0;
        int j=1;
        while(j<nums.length){
            if(nums[j]!=ans[i]){
                i++;
                ans[i]=nums[j];
            }
            j++;
        }
        i++;
        for(int a=0;a<i;a++){
            nums[a]=ans[a];
        }
        return i;

            Optimized Approach : 
            *Time Complexity : O(n)*
            *Space Complexity : O(1)*
            1.Start a pointer i that initially points the first element of the array.
            2.Start another pointer j that goes from 1 till size.
            3.If the element at i and j are distinct then increment i and insert the element present at j into position of i.
            4.Atlast return i.

        */
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
}
