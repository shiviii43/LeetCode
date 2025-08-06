class Solution {
    public int longestConsecutive(int[] nums) {
        /*
            Approach 1 :O(nlogn)
        1.Use the library sort function to sort the array.
        2.Use two pointers to check if the adjacent elements are forming a subsequence or not.
        3.Keep continuing until the subsequence is maintained.

        Approach 2 : O(n)
            1.Create a HashMap and insert all the elements into it.
            2.Insert false with each element into the HashMap.
            3.Find all the elements which have a potential to start a sequence (If a number-1 exists than that numnber cannot start a sequence) mark them as true.
            4.For all the elements that are capable of starting a sequence check how long sequence they can make.
            5.Keep updating the max with the current sequence.   
        */
        HashMap<Integer,Boolean> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
           hm.put(nums[i],false);
        }
        for(int key : hm.keySet()){
            if(hm.containsKey(key-1)==false){
                hm.put(key,true);
            }
        }
        int max = 0 ;
        for(int key : hm.keySet()){
            int k=1 ;
            if(hm.get(key)==true){
                while(hm.containsKey(key+k)==true){
                    k++;
                }
            }
            max = Math.max(max,k);
        }
        return max ;

    }
}
