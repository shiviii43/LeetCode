class Solution {
    public int maxProfit(int[] prices) {
        /*
            Brute Force Aproach : 
            TC:O(n*n)
            SC:O(1)
            For each element in the array, find the profit if we sell it in the upcoming days.
            Store the Maximum profit as the answer, and update it.

        int maxP = 0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                int curP = prices[j]-prices[i];
                maxP=Math.max(maxP,curP);
            }
        }
        return maxP;

        Optimized Approach : 
        1.Make an array which keeps the track of max sell that can be done from the end.
        2.Assume the main array as the array of buying and the max suffix array as the array of selling.

        */
        int n = prices.length;
        int[] maxSell = new int[n];
        maxSell[n-1] = prices[n-1];
        for(int i=n-2;i>=0;i--){
            maxSell[i]=Math.max(maxSell[i+1],prices[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            int cur = maxSell[i]-prices[i];
            ans = Math.max(ans,cur);
        }
        return ans;
    }
}
