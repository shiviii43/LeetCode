import java.util.Arrays;
class Solution {
    public int maxProduct(int[] nums){
        /*  Approach O(n*n) : 
            1.Sort the array in ascending order (Complexity : O(n*n)).
            2.Retrieve the last 2 elements from the sorted array.
            3.Return the product of these two elements.
            (These two elements will be the largest and the second largest elements in the array and their product will give us our answer)
        
        int n=nums.length;
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
        return ((nums[n-2]-1)*(nums[n-1]-1));
        */
        //Approach 2 O(n)
        //Iterate through the array and attain the max 2 elements
        int lar=-1;
        int secLar=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=lar){
                secLar=lar;
                lar=nums[i];
            }
            else if(nums[i]>secLar){
                secLar=nums[i];
            }
        }
        return ((lar-1)*(secLar-1));
    }
}
