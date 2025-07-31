class Solution {
    public int trap(int[] height) {
        /*
            CONCEPT : 
            1.At any point water can only fill if there exists a elevation to its right and left side.
            2.There wont be any water trapped at either corner.
            3.After the above condition is true, the amount of water a point can hold will be equal to the minimum of the two elevations it comes between in minus its own height.

            APPROACH 1 : 
                *Time Complexity[O(n)]*
                *Space complexity[O(2n)]*
            1.Create a leftMax array of same size consisting of the max element from the left side.
            2.Create a rightMax array of the same size consisting of the max element from the right side.
            3.For each element now we have its height, leftMax and rightMax.
            4.Calculate total water as for each element,
                if its left and right max are greater than it then pick the min of left and right and subtract height with it.

        //First Approach Code Solution
        int n = height.length;
        //Prefix or leftMax array
        int[] lm = new int[n];
        lm[0] = height[0];
        
        for(int i=1;i<n;i++){
            if(height[i]>lm[i-1]){
                lm[i]=height[i];
            }
            else{
                lm[i]=lm[i-1];
            }
        }
        //Suffix or rightMax array
        int[] rm = new int[n];
        rm[n-1] = height[n-1];
        
        for(int i = n-2;i>=0;i--){
            if(height[i]>rm[i+1]){
                rm[i] = height[i];
            }
            else{
                rm[i] = rm[i+1];
            }
        }
        //Calculating answer
        int ans = 0;
        for(int i=0;i<n;i++){
            if(height[i]<lm[i] && height[i]<rm[i]){
                ans+=Math.min(lm[i],rm[i])-height[i];
            }
        }
        return ans;


            APPROACH 2 : 
                *Time Complexity[O(n)]*
                *Space Complexity[O(n)]*

                This approach is just a little optimized way of the above approch. In this approach instead of making two arrays which are leftMax and rightMax we only create a single array rightMax and use a pointer that works instead of the leftMax array.
                This helps us reduce the space complexity of the approach.
            
        //Second Approach Code Solution
        int n = height.length;
        
        //Prefix or leftMax pointer
        int lm = height[0];

        //Suffix or rightMax array
        int[] rm = new int[n];
        rm[n-1] = height[n-1];
        
        for(int i = n-2;i>=0;i--){
            if(height[i]>rm[i+1]){
                rm[i] = height[i];
            }
            else{
                rm[i] = rm[i+1];
            }
        }
        
        //Calculating answer
        int ans = 0;
        for(int i=0;i<n;i++){
            if(lm<height[i]){
                lm = height[i];
            }
            if(height[i]<lm && height[i]<rm[i]){
                ans+=Math.min(lm,rm[i])-height[i];
            }
        }
        return ans;

            Optimized Approach 3 :  TWO POINTER
                *Time Complexity[O(n)]*
                *Space Complexity[O(1)]*

            Just like the leftMax array was replaced by a pointer, similarly replace the rightMax array with a pointer.
            Create a Left and Right pointer that keeps the track of the leftMax and the rightMax.
            Move the pointer with the lower value.

        */
        
        int i=0,left_max=height[0],sum=0;
        int j=height.length-1,right_max=height[j];
        while (i<j)
        {
            if(left_max <= right_max)
            {
                sum+=(left_max-height[i]);
                i++;
                left_max=Math.max(left_max,height[i]);
            }
            else 
            {
                sum+=(right_max-height[j]);
                j--;
                right_max=Math.max(right_max,height[j]);
            }
        }
        return sum;
        
    }
}
