class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
            Brute Force Approach :
            *Time Complexity : O(n*m)*
            *Space Complexity : O(1)*
            1.Start iteration from the first row till the last row.
            2.For each row check for elements from 0 till the length of the row and check if the element is equal to the target element.
            Code:
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    if(matrix[i][j]==target){
                        return true;
                    }
                }
            }
            return false;

            Approach 2 : 
            *Time Complexity : O(log(n*m))*
            *Space Complexity : O(1)*
            1.Check for the last element of each row, if target is greater than the element then increase the row and move to the next row, else check for that element in the current row by column--.
            2.Start checking from the greatest element of the fisrt row and keep iterating until the row is less than the max rows and the column is greater than 0.

        */
        int row=0;
        int col=matrix[0].length-1;
        while(row<matrix.length && col>=0){
            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]<target){
                row++;
            }
            else{
                col--;
            }
        }
        return false;
    }
}
