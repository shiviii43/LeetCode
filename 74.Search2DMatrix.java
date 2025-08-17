class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
            Approach : 
            *Time Complexity : O (log(n*m))*
            *Space Complexity : O(1)*
            1.We need to traverse row by row and just check if our target is smaller than the last element of that row, if yes then target occurs in our current row, else move to the next row.
            2.We only compare with the last element of each row, if the target is smaller than the last element then simply decrement the column value.
            3.The row must be less than the max rows as we are incrementing it and the column must be greater than 0 as we are decrementing it.
            Eg. row = 0 and col = 3 with target as 11
            We will compare our target with mat[0][3] which is the last element of the first row i.e. 7, since 7<11 we move our row one step as row=1 and col=3.

        */
        int row = 0;
        int col = matrix[0].length-1;
        int maxRows = matrix.length;

        while(row<maxRows && col>=0){
            if(matrix[row][col]==target){
                return true;
            }
            else if(target>matrix[row][col]){
                //increment the row 
                row++;
            }
            else{
                col--;
            }
        }
        return false;
    }
}
