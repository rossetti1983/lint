package dp.buttomUpDp;

/**
 * Created by zhizha on 10/26/17.
 * Say you have an array for which the ith element is the price of a given stock on day i.
 Design an algorithm to find the maximum profit. You may complete at most two transactions.
 */
public class BestTimetoBuyandSellStockIII151 {

    public static void main(String[] arg){
        BestTimetoBuyandSellStockIII151 bestTimetoBuyandSellStockIII151 = new BestTimetoBuyandSellStockIII151();
        bestTimetoBuyandSellStockIII151.maxProfit(2,new int[]{1,2,4,2,5,7,2,4,9,0});
    }
    /*
    * @param prices: Given an integer array
    * @return: Maximum profit
    */
    public int maxProfit(int K, int[] prices) {

        // write your code here
        if(prices==null || prices.length < 2){
            return 0;
        }

        int[][] local = new int[prices.length+1][K+1];
        int[][] global = new int[prices.length+1][K+1];

        int[] localMin = new int[prices.length];
        int[] globalMin = new int[prices.length];
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0 ; i < prices.length ; i++){
            if(prices[i]<min){
                min = prices[i];
                minIndex = i;
                globalMin[i] = minIndex;
            }else{
                globalMin[i] = minIndex;
            }
            if(i == 0){
                localMin[i] = i;
            }else{
                if(prices[i] < prices[i-1]){
                    localMin[i] = i;
                }else{
                    localMin[i] = localMin[i-1];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int j = 1 ; j <= K;  j++){

            int haveToTXProfit = 0;
            inner:
            for(int i = 1; i <= prices.length; i++){
                if(i<=j*2){
                    if(i%2 == 0){
                        haveToTXProfit = haveToTXProfit + prices[i-1]-prices[i-2];
                    };
                    if(i==j*2){
                        local[i][j] = haveToTXProfit;
                        global[i][j] = haveToTXProfit;
                        if(global[i][j] > max){
                            max = global[i][j];
                        }
                    }
                }else{
                    if(localMin[i-1] == i-1){
                        local[i][j] = 0;
                    }else {
                        local[i][j] = Math.max((prices[i - 1] - prices[localMin[i - 1]] + global[localMin[i - 1]][j - 1]), (prices[i - 1] - prices[globalMin[i-1]] + global[globalMin[i-1]][j - 1]));
                    }
                    global[i][j] = Math.max(local[i][j], global[i-1][j]);
                    if(global[i][j] > max){
                        max = global[i][j];
                    }
                }
            }

        }
        return Math.max(max,0);


    }
}
