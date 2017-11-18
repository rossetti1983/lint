package dp.buttomUpDp;

/**
 * Created by zhizha on 10/4/17.
 */
public class PaintHouse515 {

    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // Write your code here
        if(costs==null || costs[0].length==0){
            return 0;
        }
        int[][] dp = new int[costs.length][costs[0].length];


        for(int i = 0; i<costs.length; i++){
            for(int j = 0; j < costs[0].length; j++){
                if(i==0){
                    dp[i][j] = costs[i][j];
                }else {
                    if (j == 0) {
                        dp[i][j] = costs[i][j] + Math.min(dp[i-1][1], dp[i-1][2]);
                    } else if (j == 1) {
                        dp[i][j] = costs[i][j] + Math.min(dp[i-1][0], dp[i-1][2]);
                    } else {
                        dp[i][j] = costs[i][j] + Math.min(dp[i-1][0], dp[i-1][1]);
                    }
                }
            }
        }

        return Math.min(dp[costs.length-1][0], Math.min(dp[costs.length-1][1],dp[costs.length-1][2]));
    }
}
