class Solution {
    public void sortColors(int[] nums) {
    /*
        Approach 1:
            Using sorting algorithms :
            [Insertion Sort, Bubble Sort, Selection Sort] - O(n*n)
            [Merge Sort, Quick Sort, Heap Sort] - O(n logn)
        Approach 2 : 
            Using HashTable : O(n)
            1.Traverse the array.
            2.Insert all the elements into HashTable with their frequency.
            3.Iterate the HashTable and insert the value upto frequency.
            *This approach takes total two passes not one*
        Approach 3 : 
            Using Two Pointer Algorithm : O(n)
            *Dutch National Flag Algorithm*
            1.Use three pointers as low, mid and high.
            2.The low and mid points to the first element and high to last
            3.Start a loop that goes until mid<=high and check : 
                if mid == 0 swap with start element and increment start
                if mid == 1 do nothing 
                if mid == 2 swap with the end element and increment end
                At last increment mid

            THIS SWAPS OUR ELEMENTS IN ONE-PASS 
    */

        int start = 0;
        int mid = 0;
        int end = nums.length-1;
        while(mid<=end){
            if(nums[mid]==0){
                int temp=nums[mid];
                nums[mid]=nums[start];
                nums[start]=temp;
                start++;
                mid++;
            }
            else if(nums[mid]==2){
                int temp=nums[mid];
                nums[mid]=nums[end];
                nums[end]=temp;
                end--;
            }
            else{
                mid++;
            }
            
        }
    }
}
