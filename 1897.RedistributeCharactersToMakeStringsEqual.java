class Solution {
    public boolean makeEqual(String[] words) {
        /*

        *The main goal here is to make each word equal in a String*
        *Equal on the basis of weight and not length*
        Eg: 
            ["aaaaaaaaa","b"]
            -When divided in terms of length, the answer will be true as two words will be ["aaaaa","aaaab"]
            -But according to the question we have to divide on the basis of weight, so answer is false as we have -1b and +1a.
        
        Hash : 
        Time Complexity : O(n)
        Space Complexity : O(n)
        Since we have to track the number of occurances of each alphabet, we use HASHMAP.
        1.Create a HashMap.
        2.Since we need to access a single character as a time we need to change the string array into a StringBuilder first.
        3.Insert character and its frequenxy into the HashTable.
        4.We need that each character must be present in each word in equal number of times, so we will modulus divide the frequency of every character with the number of words in our string array.
        5.If there exist any character that leave a remainder other than 0 then that character won't be equally divided among the words.
        6.Else if all have a remainder as 0 then return true, else return false.
        CODE:
        HashMap<Character,Integer> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int n = words.length;
        for(int i=0;i<n;i++){
            sb.append(words[i]);
        }
        //inserting into the HashMap
        for(int i=0;i<sb.length();i++){
            if(hm.containsKey(sb.charAt(i))){
                hm.put(sb.charAt(i),hm.get(sb.charAt(i)+1));
            }
            else{
                hm.put(sb.charAt(i),1);
            }
        }
        //Now check if there exists any character that leave 1 rem
        for(Map.Entry<Character,Integer> e : hm.entrySet()){
            if(e.getValue()%n!=0){
                return false;
            }
        }
        return true;

        Approach 2 :
        Time Complexity : O(n)
        Space Complexity : O(1) 
        1.Make an array of length 26 for storing the frequency of each character.
        2.To access each character we first need to convert the string array into a string or a StringBuilder object.
        3.Now from the StringBuilder for each character increment the frequency of that character.
        4.Now that the frequency of all the characters have been stored, check that each frequency is completly divisible by the number of words in the string array.
        5.If there is a remainder of even a single element then false
        6.Else return true if all are completly divisible.
        */

        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();
        int n = words.length;
        for(int i=0;i<n;i++){
            sb.append(words[i]);
        }
        for(int i=0;i<sb.length();i++){
            char ch = sb.charAt(i);
            int idx = (int)ch-'a';
            freq[idx] += 1;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i]%n!=0){
                return false;
            }
        }
        return true;
    }
}
