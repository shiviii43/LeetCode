class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*
            Approach 1 : O(nlogn)
            *With Sorting*
            1.Use the Library sort function to sort the array.
            2.Return Size-k th element of the sorted array.
            Code
            Arrays.sort(nums);
            int n = nums.length-k;
            return nums[n];

            Approach 2 : 
                *Time Complexity O(n)*
                *Space Complexity O(n)*
            1.Create a priority queue and insert all the elements of the array into the priority queue.
            2.Remove the elements from the priority queue until it contains k number of element.
            *Since the elements in a priority queue are removed in ascending order the remaining elements will be the k largest, ex: if k is 3 then the remaining elements are the three largest*
            3.To obtain the smallest one of the remaining largest we simply use the peek method which return the minimum of the queue.
            Code
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            for(int ele : nums){
                pq.add(ele);
            }
            int n = pq.size()-k;
            for(int i=0;i<n;i++){
                pq.remove();
            }
            return pq.peek();

            Approach 3 : 
                *Time Complexity O(n)*
                *Space Complexity O(1)*
            1.Create a Priority Queue.
            2.Insert k number of elements from the starting into the priority queue.
            3.If the new element is greater than the one at the peek, simply remove the peek element and insert the new element.
            4.After the whole array is traversed the priority queue contains of k largest elements of the array.
            5.Return the peek element of the Priority Queue.
        */

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0;i<nums.length;i++){
            if(pq.size()<k){
                pq.add(nums[i]);
            }
            else if(pq.peek()<nums[i]){
                pq.remove();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}
