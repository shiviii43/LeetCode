class Solution {
    public int maximumCount(int[] nums) {
        /*
            Approach 1 : O(n)
            Simply traverse the array and keep the count of numbers that are less than 0.
            Another count of total numbers greater than 0.
            Return the Maximum of them.

            Code Solution 
            int pos = 0;
            int neg = 0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]>0) pos++;
                else if(nums[i]<0) neg++;
            }
            return Math.max(pos,neg);
        
            Optimized Approach : O(log n)
            1.Use Binary Search to find out the last negative number and the first positive number.
            2.Properties will be as : 
                a.The last negative number will have either a zero or a positive number as its right neighbour.
                b.The first positive number will have either a zero or a negative number at its left neighbour.
            3.Calculate as : 
                Total negative numbers  = index+1
                Total positive numbers = n-index
            Take the initials as for negative index take -1 and for positive index take n.

        */

        int n = nums.length-1;
        int negIndex = -1;
        int posIndex = nums.length;
        //Finding out the largest negative number 
        int low=0;
        int high = n;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]<0){
                negIndex = mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        //Finding out the smallest positive number 
        low=0;
        high=n;
        while(low<=high){
            int mid=(low+high);
            if(nums[mid]>0){
                posIndex=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        negIndex+=1;
        posIndex = nums.length-posIndex;
        return Math.max(posIndex,negIndex);
    }
}
