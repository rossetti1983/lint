package dp.buttomUpDp;

/**
 * Created by zhizha on 9/4/17.
 */
public class Triangle109 {

    public static void main(String[] arg){
        Triangle109 triangle109 = new Triangle109();
        triangle109.minimumTotal(new int[][]{{2},{3,4},{6,5,7},{4,1,8,3}});
    }

    public int minimumTotal(int[][] triangle) {
        if(triangle == null || triangle.length == 0 ){
            return 0;
        }
        int n = triangle.length;
        int m = triangle[n-1].length;
        // write your code here
        int[][] dp = new int[n+1][m+1];
        for(int i = n-1; i>=0; i--){
            for(int j = 0; j <= i; j++){
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + triangle[i][j];
            }
        }

        return dp[0][0];
    }
}
