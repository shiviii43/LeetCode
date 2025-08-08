class Solution {
    public int numRescueBoats(int[] people, int limit) {
        /*
            Approach : O(n*n)
            1.For each element of the array find elements that either sum upto the limit or to the closest of the limit.
            2.Remove those elements from the array and increase the number of boats for them.

            Approach 2 : O(nlogn)
            **Two Pointers**
            1.Sort the Array.
            *After sorting this problems becomes more like the two sum problem in a sorted array*
            2.Create two pointers start and end pointers.
            3.Till start pointer is less than and equal to end, check for conditions as: 
                if(arr[start]+arr[end]>limit)
                The element at end cannot pair up with any number in the array and has to go in a boat alone.
                if(arr[start]+arr[end]<=limit)
                We need to send these two people together in a boat as it will either be equal to the limit or the closest to it.
            4.AtLast return the number of boats that were required.

        */
        Arrays.sort(people);
        int start=0;
        int end=people.length-1;
        int boat=0;
        while(start<=end){
            int weightSum = people[start]+people[end];
            if(weightSum<=limit){
                //These two will be either equal or closest to limit
                start++;
            }
            end--;
            boat++;
        }
        return boat;
    }
}
