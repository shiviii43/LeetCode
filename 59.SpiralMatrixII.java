class Solution {
    public int[][] generateMatrix(int n) {
        /*
            Approach : 
            1.Use 4 pointers as top, left, right and bottom.
            2.Use these pointers to traverse from the outer shell of the matrix.
            3.Keep a variable as a count of till which number the sequence has been inserted, keep incrementing it after every traversal.
            4.The traversal sequence will go as :
                a.Left to right
                b.Top to bottom
                c.Right to left
                d.Bottom to top

            5.At the end return the matrix as the answer.
        
        */

        //Create a matrix of n*n size
        int[][] mat = new int[n][n];
        int val=1;
        int left=0;
        int right=n-1;
        int top=0;
        int bottom=n-1;
        while(val<=n*n){  //0<=9
            //Left to right
            for(int i=left;i<=right;i++){
                mat[left][i]=val;
                val++;
            }
            top++;
            //Top to bottom
            for(int i=top;i<=bottom;i++){
                mat[i][bottom]=val;
                val++;
            }
            right--;
            //Right to left
            for(int i=right;i>=left;i--){
                mat[bottom][i]=val;
                val++;
            }
            bottom--;
            //Bottom to top
            for(int i=bottom;i>=top;i--){
                mat[i][left]=val;
                val++;
            }
            left++;
        }
        return mat;
    }
}
