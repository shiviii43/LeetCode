class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /*
            Approach :
            TC:O(N)
            SC:O(N)
            1.Create a HashMap which stores the number and its last occurance.
            2.Iterate the array from the starting to the ending.
            3.If the element does not exist in the HashMap then insert that element in the HashMap with its index as the value.
            4.If it wxists already then fetch its last occurance and then check for the less than k condition with both the occurances, if it satisfies then return true, else return false.

        */
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i],i);
            }
            else{
                int prevOcc = hm.get(nums[i]);
                if(Math.abs(prevOcc-i)<=k){
                    return true;
                }
                hm.replace(nums[i],i);
            }
        }
        return false;
    }
}
