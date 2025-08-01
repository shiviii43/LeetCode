class Solution {
    public String largestNumber(int[] nums) {
        
        //Convert this into a string array
        String[] str = new String[nums.length];
        //Choose every element and add an empty string to it
        for(int i=0;i<nums.length;i++){
            str[i] = nums[i]+"";
        }
        //The next step is to sort it
        Arrays.sort(str,(st1,st2)->(st1+st2).compareTo(st2+st1));
        StringBuilder sb = new StringBuilder("");
        //Inserting elements into the sb reference in reverse order
        for(int i=nums.length-1;i>=0;i--){
            sb.append(str[i]);
        }
        //If the maximum element is 0 means the number we need to return is 0.
        if(sb.charAt(0)=='0'){
            return "0";
        }
        return sb.toString();
    }
}
