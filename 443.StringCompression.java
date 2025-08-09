class Solution {
    public int compress(char[] chars) {
        /*
            Approach 1 : O(n) 1 ms 
            *TWO POINTER*
            1.Create two pointers i and j, with a count as 1.
            2.Create a StringBuilder object.
            3.Start a loop until j is less than the size of chars.
            4.If i and j are at the same element then insert that element into the Builder and increment j.
            5.If element at i and j are equal then increment the count and increment j.
            6.Else if the elements at i and j are not equal meaning that we got a new character, first insert the previous count into the builder, then restart the count from 1 and make i point the same character/index as j so that we can insert it into the builder.
            7.Atlast check for the ending condition, if count is more than 1 then add count and make changes in the array until the length of the builder object.
            8.Return the length of builder.

        CODE : 
        int i=0;
        int j=0;
        int count=1;
        StringBuilder sb = new StringBuilder("");
        while(j<chars.length){
            if(i==j){
                sb.append(chars[i]);
                j++;
            }
            else if(chars[i]==chars[j]){
                count++;
                j++;
            }
            else{
                if(count>1) sb.append(count);
                count=1;
                i=j;
            }
        }
        if(count>1){
            sb.append(count);
        }
        int ans = sb.length();
        for(int a=0;a<ans;a++){
            char ch = sb.charAt(a);
            chars[a] = ch;
        }
        return ans;


            Approach 2 : O(n) 2ms
            1.Create a String Builder and insert the first element of the array into the string builder and create a count variable.
            2.Start a loop from the second element till the last element of the chars array.
            3.If the element at i and the one at i-1 are equal increment the count variable.
            4.Else insert the count into the builder, then restart the count and after that insert the new character as well.
            5.After the loop is ended check if count is greater than 1 if yes then add count into the builder as well.
            6.After that same as the above approach, make changes in the initial array from the builder until the length of builder.
            7.At end return the length of the builder.

        */

        StringBuilder sb = new StringBuilder("");
        sb.append(chars[0]);
        int count=1;
        for(int i=1;i<chars.length;i++){
            if(chars[i]==chars[i-1]){
                count++;
            }
            else{
                if(count>1) sb.append(count+"");
                count=1;
                sb.append(chars[i]);
            }
        }
        if(count>1) sb.append(count+"");
        int ans = sb.length();
        for(int i=0;i<ans;i++){
            char ch = sb.charAt(i);
            chars[i] = ch;
        }
        return ans;
    }
}
