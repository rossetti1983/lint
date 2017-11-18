package dp;

import java.util.HashMap;

/**
 * Created by zhizha on 8/30/17.
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most k transactions.

 Notice

 You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

 Have you met this question in a real interview? Yes
 Example
 Given prices = [4,4,6,1,1,4,2,5], and k = 2, return 6.


 */
public class BestTimetoBuyandSellStockIV393 {

    public static void main(String[] arg){
        BestTimetoBuyandSellStockIV393 bestTimetoBuyandSellStockIV393 = new BestTimetoBuyandSellStockIV393();
        bestTimetoBuyandSellStockIV393.maxProfit(4,new int[]{8,3,6,2,8,4,2,0,7,2,9,4,9});
    }
    HashMap<String,Integer> cache = new HashMap<>();
    public int maxProfit(int K, int[] prices) {
        // write your code here
        if(prices==null || prices.length<2){
            return 0;
        }
        if(K==0){
            return 0;
        }
        return maxProfit(prices, K, 0, 0, 0);
    }

    public int maxProfit(int[] prices, int remK, int start, int stock, int profit){
        if(cache.containsKey(remK+","+start+","+stock)){
            return cache.get(remK+","+start+","+stock)+profit;
        }
        if(remK==0){
            return profit;
        }
        if(start>=prices.length){
            return profit;
        }
        if(stock==0){
            int max = Integer.MIN_VALUE;
            for(int i = start ; i <= prices.length; i++){
                int p = 0;
                if(i==prices.length){
                   p = profit;
                }else {
                    p = maxProfit(prices, remK, i + 1, 1, profit - prices[i]);
                }
                if(p>max) {
                    max = p;
                }
            }
            cache.put(remK+","+start+","+stock, max-profit);
            return max;
        }
        else{
            int max = Integer.MIN_VALUE;
            for(int i = start ; i < prices.length; i++){
                int p = 0;
                if(i==prices.length){
                    p = profit;
                }else {
                    p = maxProfit(prices, remK - 1, i + 1, 0, profit + prices[i]);
                }
                if(p>max) {
                    max = p;
                }
            }
            cache.put(remK+","+start+","+stock, max-profit);
            return max;
        }

    }
}
