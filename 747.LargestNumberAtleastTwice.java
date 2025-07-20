class Solution {
    public int dominantIndex(int[] nums) {
        /*
            Brute Force : O(n)
            1.Find out the maximum in the Array.
            2.Check for individual element that whether their double is less than the maximum element or not.  
            CODE :
        //Find the maximum number 
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[max]){
                max = i;
            }
        }
        // System.out.print(max);
        int flag = 1;
        for(int i=0;i<nums.length;i++){
            if(i==max) continue;
            int n = nums[i]*2;
            if(n>nums[max]){
                flag--;
                break;
            }
        }
        if(flag==1) System.out.print(max);
        else System.out.print(-1);

            Optimized or Better Approach: O(n)
            1.Find out the largest and the second largest element.
            2.If twice the second largest is greater then return -1.
            2.Else return index of maximum element.
        */
        int max = -1 ;
        int smax = -1 ;
        int maxIdx = 0 ;

        for(int i=0;i<nums.length;i++){
            if(max<nums[i]){
                smax=max ;
                max = nums[i];
                maxIdx = i ;
            }else if ( smax < nums[i]){
                smax = nums[i];
            }
        }

        if(smax*2<=max){
            return maxIdx;
        }else{
            return -1 ;
        }
    }
}
