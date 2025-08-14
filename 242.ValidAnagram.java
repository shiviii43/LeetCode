class Solution {
    public boolean isAnagram(String s, String t) {
        /*
            [Base case : Both Strings must have equal lengths.]

            Approach 1 : 
            **Sorting**
            *Time Complexity : O(nlogn)*
            *Space Complexity : O(1)*
            1.Sort the both strings using inbuilt functions.
            2.Use a for loop and iterate both the Strings using a same iterator, and check if both have same elements.
            3.If there exists any distinct character then false.
            4.Else return true.

            Approach 2 :
            **HashMap**
            *Time Complexity : O(n)*
            *Space Complexity : O(n)*
            1.Create two HashMaps for the Strings.
            2.Traverse the String and insert the character and it's corresponding frequency into the HashMap.
            3.Similarly for the Second String repeat the same process and store in the Second HashMap.
            4.Compare the frequency of each element from HashMaps.
            5.If the frequency of each existing character is same in both the HashMaps then return true, else return false.

            Approach 3 :
            **Counting**
            *Time Complexity : O(n)*
            *Space Complexity : O(n)*
            1.Create a array of 26 size and store the frequency of each character, do the same for both the arrays.
            2.Use a loop and check whether both the arrays are equal or not, if yes then return True else False.
            
            (Better make a single array and first add frequency and then subtract it, check for the condition that if any frequency is not equal to 0 return false.)


            [FOLLOW UP]
            If the string contains unicode characters then simply before updating the frequency check for the condition that the character must be between 'a' and 'z'.
        */

        if(s.length()!=t.length()) return false;
        int[] freq1 = new int[26];
        //int[] freq2 = new int[26];

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int idx = (int)ch-'a';
            freq1[idx] += 1;
        }
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            int idx = (int)ch-'a';
            freq1[idx] -= 1;
        }
        for(int i=0;i<freq1.length;i++){
            if(freq1[i]!=0){
                return false;
            }
        }
        return true;
    }
}
