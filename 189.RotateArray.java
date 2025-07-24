class Solution {
    public void rotate(int[] nums, int k) {
        /*
            Approach 1 : [MATH SOLUTION]
            1.Create a new array of the same length to store the elements.
            2.Traverse the first array and insert the elements linearly.
            3.Use Array2[(i+k)%size of array] = Array1[i].
            4.Return the new array or replace the intial array with new.
            This approach takes a time complexity of O(n) but a space complexity of O(n) as well.

            Approach 2 :   [No NEW array required]
            [TWO POINTERS]
            1.Reverse the whole array.
            2.Reverse the array from 0 to k-1.
            3.Reverse the remaining array, from k till n-1.
            For handling k's value greater than the length of array : 
            Simply update k as k = k % size of array.
        */
        
        //Update k = k % 10 for handling k greater cases 
        int n = nums.length;
        k %= n;
        //Step1 - reverse the whole array
        reverse(nums,0,n-1);
        //Step2 - reverse from 0 to k-1
        reverse(nums,0,k-1);
        //Step3 - reverse from k to n-1
        reverse(nums,k,n-1);
    }
    //REVERSE Function
    public void reverse(int[] arr,int start,int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}
