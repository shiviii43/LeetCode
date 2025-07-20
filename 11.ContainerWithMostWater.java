class Solution {
    public int maxArea(int[] height) {
        //Start pointer 
        int start = 0;
        //End pointer 
        int end = height.length-1;
        //Area 
        int area = 0;
        while(start<end){
            int curHeight = 0;
            if(height[start]<height[end]){
                curHeight = height[start];
            }
            else{
                curHeight = height[end];
            }
            //We've choosen the smaller height
            int tempArea = curHeight*(end-start);
            if(area<tempArea){
                area = tempArea;
            }
            if(curHeight==height[start]) start++;
            else end--;
        }
        return area;
    }
}
