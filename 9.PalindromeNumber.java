class Solution {
    public boolean isPalindrome(int x) {
        //Edge case : when the number is negative.
        if(x<0){
            return false;
        }
        int n=x;
        int rev=0;
        while(n>0){
            int rem = n%10;
            n/=10;
            rev = rev*10+rem;
        }
        if(rev==x){
            return true;
        }
        return false;
    }
}
