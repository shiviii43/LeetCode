class Solution {
    public boolean isPowerOfTwo(int n) {
        //Edge case : Neagtive numbers and zero cannot be true.
        if(n<1){
            return false;
        }
        //Edge case: 1 is the only odd power of 2.
        else if(n==1){
            return true;
        }
        while(n%2==0){
            n/=2;
        }
        if(n==1){
            return true;
        }
        return false;
    }
}
