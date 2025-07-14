class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
          int totalDrunk = 0;
          int emptyBottles= 0;
          int extraEmptyBottles=0;
          do{
            totalDrunk+=numBottles;    //15+3+1
            emptyBottles = numBottles+extraEmptyBottles;  //3
            numBottles = emptyBottles/numExchange;    //0
            extraEmptyBottles = emptyBottles%numExchange;    //0

        }while(emptyBottles>=numExchange);  //3>=4
        return totalDrunk;
    }
}
