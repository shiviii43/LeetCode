class Solution {
    public void rotate(int[][] matrix) {
        /*
            Approach 1 :
            -Time Complexity : O(n*n)-
            -Space Complexity : O(1)-

            1.Find out the transpose of the matrix.
            2.Reverse the elements Row-wise or Horizontally.
            **Transpose and Horizontal Reverse**
        Code
        //Transpose
        int n=matrix.length;
        for(int row=0;row<n;row++){
            for(int col=row+1;col<n;col++){
                int temp=matrix[row][col];    
                matrix[row][col]=matrix[col][row];
                matrix[col][row]=temp;  
            }
        }
        //Reverse Horizontally 
        for(int i=0;i<n;i++){
            int sp=0;
            int ep=n-1;
            while(sp<ep){
                int temp=matrix[i][sp];
                matrix[i][sp]=matrix[i][ep];
                matrix[i][ep]=temp;
                sp++;
                ep--;
            }
        }


            Approach 2:
            1.Reverse the matrix Column-wise or Vertically.
            2.Find the Transpose of the reversed matrix.
            **Vertical Reverse and Transpose**

        */

         int n=matrix.length;
        //Reverse Vertically
        for(int i=0;i<n;i++){
            int sp=0;
            int ep=n-1;
            while(sp<ep){
                int temp=matrix[sp][i];
                matrix[sp][i]=matrix[ep][i];
                matrix[ep][i]=temp;
                sp++;
                ep--;
            }
        }
        //Transpose
        for(int row=0;row<n;row++){
            for(int col=row+1;col<n;col++){
                int temp=matrix[row][col];    
                matrix[row][col]=matrix[col][row];
                matrix[col][row]=temp;  
            }
        }
    }
}
