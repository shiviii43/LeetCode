class Solution {
    public int maximum69Number (int num) {
        /*
            Approach 1 : 
            1.Create an ArrayList to store the digits of the number, since the number of digits the number will contain cannot be determined we will use an ArrayList that can grow accordingly.
            2.Start extracting the digits from the LSD to MSD from the number by attaining the remainder after division by 10, and then insert it into the ArrayList.
            3.This way our ArrayList will contain the reverse of our original number.Example : If num=9966 then list contains 6699
            4.Traverse the list from the end till the front and check for the first occurance of a 6, once a 6 is found change it to 9 and break the loop as we only need to make a single change.
            5.Now our list contains our answer just in the reverse order, so create a variable and keep inserting elements from the end till the from the list and to maintain the digit places multiply it by 10 for each digit.
            6.Return the achieved answer.
            
        */
        //num = 9966
        List<Integer> li = new ArrayList<>();
        int n = num;
        while(n>0){
            int rem = n%10;
            li.add(rem);
            n /= 10;
        }               //li = [6,6,9,9]
        for(int i=li.size()-1;i>=0;i--){
            if(li.get(i)==6){
                li.set(i,9);
                break;
            }
        }               //li = [6,9,9,9]
        int ans=0;
        for(int i=li.size()-1;i>=0;i--){
            ans = ans*10+li.get(i);     //9996
        }
        return ans;
    }
}
