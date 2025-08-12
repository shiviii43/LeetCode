class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        /*
            Approach : O(n*n) and O(1)
            1.First traverse the top row from left to right.
            2.Then traverse the outermost right column from top to bottom.
            3.Then traverse the bottom row from right to left.
            4.Then traverse the outermost left column from bottom to top.
            5.Keep decrementing the bottom and right, and keep incrementing the left and top with each layer removed.
            6.Continue this until the left is less than right and the top is less than bottom, once any one of top or left becomes greater then stop.
        */
        ArrayList<Integer> li = new ArrayList<Integer>();
        
        //4 pointers 
        int left=0;
        //Length of the row of matrix
        int right=matrix[0].length-1;
        int top=0;
        //Length of the column of matrix
        int bottom=matrix.length-1;
        
        while(top<=bottom && left<=right){
            
            //Left -> Right
            for(int i=left;i<=right;i++){
                li.add(matrix[top][i]);
            }
            top++;
            //Top -> Bottom
            for(int i=top;i<=bottom;i++){
                li.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
                //Right -> Left
                for(int i=right;i>=left;i--){
                    li.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                //Bottom -> Top
                for(int i=bottom;i>=top;i--){
                    li.add(matrix[i][left]);
                }
                left++;
            }
        }
        return li;
    }
}
