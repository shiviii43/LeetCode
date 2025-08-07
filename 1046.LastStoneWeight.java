class Solution {
    public int lastStoneWeight(int[] stones) {
        
        /*  
            Brute Force Approach : O(n*n)
            1.Copy the array into a list of Integers.
            2.Run a loop until the list contains more than 1 element
            3.Inside this loop run another loop to find the indices of largest and the second largest elements from the current list.
            4.After finding them, apply the operations as per the question.
            5.If both are equal then remove both of them from the list.
            6.Else update the largest as largest = largest-SecondLargest and with it remove the second largest from list
            7.With each iteration one element gets removes, continue until there is a single element remaining into the list.
            8.Return the last remaining element of the list.

            Priority Queue : O(nlogn)
            *Max Heap*
            1.Create a priority queue that uses that max heap property.
            2.Insert all the elements of the array into the priority queue
            3.Continue a loop until the length of queue is 1, in this loop remove two elements from the queue which would be the max and the second max.
            4.Store lar-sec into a variable, if the value is not equal to zero insert it back into the queue, else don't.
            5.After the loop if there are no elements in the queue then return 0 as the answer, else return the value left in the queue.

        */
        //Max Heap -> Collections.reverseOrder()
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        //Inserting into the Queue
        for(int ele : stones){
            pq.add(ele);
        }
        while(pq.size()>1){
            int lar=pq.remove();
            int sec=pq.remove();

            int newStone = lar-sec;
            //If stone not zero insert it in queue
            if(newStone!=0){
                pq.add(newStone);
            }
        }
        if(pq.size()==0) return 0;
        return pq.remove();
    }
}
