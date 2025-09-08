class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        /*
            Brute Force : 
            TC:O(N^2)
            SC:O(N)
            1.Traverse the num1 array from the starting to the end.
            2.For each element search for the equal element in the num2 array.
            3.When the same element in found in the nums 2, iterate the remaining array and search for the greater element.
            4.Keep inserting these greater values in am array of size the same as the nums1, if no greater is found insert -1.

            Optimized Approach : 
            TC:O(N)
            SC:O(3N)
            1.Use a Monotonic stack and create a NGE array for the nums2 array. --> tc-O(n), sc-O(2n)
            2.Iterate the nums1 array and search for the same element in the nums2 array, at the index at which the element is found simply return the element at that index from the NGE array. 
            3.Store the answer in an array and return the array.

        */
        int n = nums2.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i] = -1;
            }
            else{
                nge[i] = st.peek();
            }
            st.push(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<n;j++){
                if(nums1[i]==nums2[j]){
                    ans[i]=nge[j];
                }
            }
        }
        return ans;
    }
}
