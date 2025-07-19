class Solution {
    public int bulbSwitch(int n) {

        /*Approach : 
            All numbers have even number of factors.
            Example : 
            2 = 1 and 2 
            3 = 1 and 3 
            32 = 1, 2, 4, 8, 16, 32
            48 = 1, 2, 3, 4, 6, 8, 12, 16, 24, 48
            So basically, all the bulbs on these numbers will return to its initial stage i.e. closed/off.

            But there are some numbers such as : 
            1 = 1
            4 = 1, 2, 4
            9 = 1, 3, 9
            These numbers have odd number of factors meaning that the bulbs that are on these numbers will have a different final stage i.e. open/on.

            These numbers are PERFECT SQUARES.
            So, all we need to do is search for how many perfect sqaures occur between the given range.

            */

        int count = 0 ;
        int i=1;
        while(i*i<=n){
            count++;
            i++;
        }
        return count;
        
    }
}
