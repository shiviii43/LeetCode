class Solution {
    public int findDuplicate(int[] nums) {
        /*
            Brute Force : O(n*n)
            1.Use two loops to find out if the current element is equal to any other element in the array.
            2.If yes then return that element.

            Sort : O(nlogn) O(1)
            1.Use the library sort and sort the array.
            2.Traverse the array and check if the current element is different from its +1 element.
            3.If not then return the number.

            Hash : O(n) and O(n)
            *HashSet only stores unique elements*
            1.Create a HashSet and insert the elements into it.
            2.If we try to insert an already existing element into a hashSet then the insert function return false.
            3.If it is false then return that element.
            Code:
            HashSet<Integer> hs = new HashSet<Integer>();
            for(int i=0;i<nums.length;i++){
                if(!hs.add(nums[i])){
                    return nums[i];
                }
            }
            return -1;

            Approach 4 : O(n) and O(1)
            *Since all the elements ranges from 1 to n we can use them to visit that index*
            1.For every index of array visit the value which is stored and mark it as negative.
            Eg: The first element of the array is 3 then go ahead and mark the element at index 3 as negative.
            2.Basically each element will be visited only once and made negative, if an index it visited and it is already negative then that index or that value is the duplicate value.
            3.Store the answer and before returning it, make sure to make the whole array as before because we do not need to make any changes in the initial array.

            Two Pointers : O(n) and O(1)
            *Fast and Slow Pointers*
            1.Visualize the array as a linked list.
            (Same as find a cycle in a linked list)
            Eg: [1,3,4,2,2]
                0->1->3->2->4->2
                the zero index will point to element at it i.e. 1, similarly at index 1 we find 3 so 1 will point to 3 and so on a cycle will form in the linked list. i.e. 4->2 and 2->4
            2.Use two pointers and find the first point of intersection of those pointers.(Fast=two steps,Slow=one step)
            3.After this apply floyd's algorithm.
            4.Return the point of intersection.

        */
        int slow = 0;
        int fast = 0;
        //Find the first point of intersection of both pointers
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        //Floyd's algorithm
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}
