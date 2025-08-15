class Solution {
    public int[][] transpose(int[][] matrix) {
        /* 
            Approach : 
            *Time Complexity : O(m*n)*
            *Space Complexity : O(m*n)*
            1.Create a new matrix of size col*row so that if it is a rectangle matric then for [3][4] a new [4][3] is made and for sqaure matrix the size will remain same.
            2.We can see a pattern as the 01 element is replaced by the 10 and this follows up for every element.
            3.Insert the element at [i][j] into the transpose matrix at [j][i] position.
            4.We will return the answer matrix.

        */
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] trans = new int[col][row];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                trans[j][i] = matrix[i][j];
            }
        }
        return trans;
    }
}
