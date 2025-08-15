class Solution {
    public int diagonalSum(int[][] mat) {
        /*
            Approach : 
            *Time Complexity : O(n)*
            *Space Complexity : O(1)*
            1.We will create two iterators i and j.
            2.For the PRIMARY DIAGONAL we can see the pattern of indices as {00,11,22,33,44,55,...} so we will iterate for the same values of both i and j starting from 0 till the size-1.
            3.For the SECONDARY DIAGONAL we can see the pattern of indices as {04,13,22,31,40} so we will iterate i from 0 to size-1 and j as the opposite of i which is from size-1 till 0.
            4.When the matrix is of even size then there will not be any repeating element, only when the matrix will be of odd size it will consist of a common diagonal element.
            5.So for getting rid of the repeating element, we will check for the value of i and j when calculating the sum of the secondary diagonal of the matrix OR simply before adding both sum check for the length of matrix and subtract the middle element from the secondary sum.

        */
        int priSum=0;
        int secSum=0;
        int n=mat[0].length;
        //Primary Sum
        for(int i=0;i<n;i++){
            priSum+=mat[i][i];
        }
        //Secondary Sum
        int j=n-1;
        for(int i=0;i<n;i++){
            secSum+=mat[i][j];
            j--;
        }
        //Check if we need to subtract from the secondary or not
        if(n%2!=0){
            int mid=n/2;
            secSum-=mat[mid][mid];
        }
        return priSum+secSum;
    }
}
