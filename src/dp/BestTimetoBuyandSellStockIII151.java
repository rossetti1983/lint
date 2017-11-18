package dp;

import java.util.HashMap;

/**
 * Created by zhizha on 8/30/17.
 */
public class BestTimetoBuyandSellStockIII151 {
    public static void main(String[] arg) {
        BestTimetoBuyandSellStockIII151 BestTimetoBuyandSellStockIII151 = new BestTimetoBuyandSellStockIII151();
        BestTimetoBuyandSellStockIII151.maxProfit(new int[]{3,3,5,0,0,3,1,4});
    }

    HashMap<String, Integer> cache = new HashMap<>();

    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int max = maxProfit(prices, 2, 0, 0);
        return max;
    }

    public int maxProfit(int[] prices, int remK, int start, int profit) {
        if (cache.containsKey(remK + "," + start)) {
            return cache.get(remK + "," + start) + profit;
        }
        if (remK == 0) {
            return profit;
        }
        if (start >= prices.length) {
            return profit;
        }
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= prices.length; i++) {
            int p = 0;
            if (i == prices.length) {
                p = profit;
                if (p > max) {
                    max = p;
                }
            }

            if (i + 1 <= prices.length - 1) {
                int p1 = maxProfit(prices, remK, i + 1, profit);
                int p2 = 0;
                int p2Max = Integer.MIN_VALUE;
                for (int j = i + 1; j < prices.length; j++) {
                    if(j+1 <= prices.length-1 && prices[j+1]>prices[j]){
                        continue;
                    }
                    int profitThisTX = (prices[j] - prices[i]);
                    p2 = maxProfit(prices, remK - 1, j + 1, profit + profitThisTX);
                    if(p2>p2Max){
                        p2Max = p2;
                    }

                }
                p = Math.max(p1, p2Max);
            } else {
                p = maxProfit(prices, remK, i + 1, profit);
            }
            if (p > max) {
                max = p;
            }
            cache.put(remK + "," + start, max - profit);
        }
        //cache.put(remK + "," + start, max - profit);
        return max;
    }
   /* public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            int p = maxProfit(prices, 2, 0, 0);
            if (p > max) {
                max = p;
            }
        }
        return max;
    }

    public int maxProfit(int[] prices, int remK, int start, int profit) {
        if (cache.containsKey(remK + "," + start)) {
            return cache.get(remK + "," + start) + profit;
        }
        if (remK == 0) {
            return profit;
        }
        if (start >= prices.length-1) {
            return profit;
        }
        int max = 0;
        for (int i = start; i < prices.length; i++) {
            int p = 0;
            for (int j = i + 1; j < prices.length; j++) {
                int profitThisTX = (prices[j] - prices[i]);
                p = maxProfit(prices, remK - 1, j+1, profit + profitThisTX);
                if (p > max) {
                    max = p;
                }
            }
        }
        cache.put(remK + "," + start, max - profit);

        return max;
    }*/
}
