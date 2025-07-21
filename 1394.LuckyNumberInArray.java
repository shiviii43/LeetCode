class Solution {
    public int findLucky(int[] arr) {
        //Create a hashmap for storing the element and its frequency
        HashMap<Integer,Integer> hm = new HashMap<>();

        //now we have to insert all array elements into the hash map 
        for(int i=0;i<arr.length;i++){
            int ele = arr[i];
            //If the element allready exists into the hashMap then all we have to do is increment its existing value
            if(hm.containsKey(ele)){
                hm.put(ele,hm.get(ele)+1);
            }
            //If it doesn't already exist then 
            else{
                hm.put(ele,1);
            }
        }
        //We have inserted all elements in the HashMap
        int ans = -1;
        //Now traverse the HashMap for searching which key == value
        for( int key : hm.keySet()){    //for key in keySet
            if(hm.get(key)==key){
                ans = Math.max(ans,key);
            }
        }
        return ans;

    }
}
