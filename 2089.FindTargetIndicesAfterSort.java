class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        /*
            Brute Force Approach : O(n log n)
            1.Use a Library sort function and sort the array.
            2.Traverse the array from the starting and campare the element with the target element, if a target element is found then simply store its index in the resulting list.

        Code solution 
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                ans.add(i);
            }
        }
        return ans;

            OPTIMISED APPROACH : O(n)

            1.Without sorting we have to find our answer.
            2.To do that we have to find how many elements occur before our target element.
            3.With this we have to find how many times did out target element occur in the array.
            4.Return a List with indexes from total elements before-1 upto the number of occurances.
            
        */
        int numsBefore = 0;
        int tarCount = 0;
        for(int ele : nums){
            if(ele==target){
                tarCount++;
            }
            else if(ele<target){
                numsBefore++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(tarCount>0){
            ans.add(numsBefore);
            numsBefore++;
            tarCount--;
        }
        return ans;
    }
}
